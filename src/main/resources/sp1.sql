CREATE OR REPLACE FUNCTION criarPodio(idCompeticao bigint) RETURNS SETOF participacao AS
$$
DECLARE
  colocacao_loop   BIGINT;
  politica         politicapontuacao%ROWTYPE;
  participacao_var participacao%ROWTYPE;
  participacoes CURSOR FOR SELECT participacao.*
                             FROM participacao
                               JOIN competicao ON competicao.id = participacao.competicao_id
                             WHERE competicao.id = idCompeticao;
BEGIN

  SELECT politicapontuacao.*
  INTO politica
  FROM politicapontuacao
    JOIN competicao ON politicapontuacao.id = competicao.politicapontuacao_id
  WHERE competicao.id = idCompeticao;

  FOR participacao_var IN participacoes LOOP
    DECLARE
      vitorias_var  INTEGER;
      empates_var   INTEGER;
      derrotas_var  INTEGER;
      pontuacao_var INTEGER;
      evento_var    evento%ROWTYPE;
        eventos CURSOR FOR SELECT evento.*
                           FROM competidor
                             JOIN evento
                               ON (competidor.id = evento.competidor1_id OR competidor.id = evento.competidor2_id)
                             JOIN competicao ON competicao.id = evento.competicao_id
                             JOIN politicapontuacao ON politicapontuacao.id = competicao.politicapontuacao_id
                           WHERE competidor.id = participacao_var.competidor_id AND competicao.id = idCompeticao;
    BEGIN
      vitorias_var := 0;
      empates_var := 0;
      derrotas_var := 0;
      pontuacao_var := 0;

      FOR evento_var IN eventos LOOP
        IF evento_var.vencedor_id = participacao_var.competidor_id
        THEN
          vitorias_var := vitorias_var + 1;
        ELSEIF evento_var.vencedor_id ISNULL
          THEN
            empates_var := empates_var + 1;
        ELSE
          derrotas_var := derrotas_var + 1;
        END IF;
      END LOOP;

      pontuacao_var := vitorias_var * politica.pontosporvitoria;
      pontuacao_var := pontuacao_var + empates_var * politica.pontosporempate;
      pontuacao_var := pontuacao_var + derrotas_var * politica.pontosporderrota;

      UPDATE participacao
      SET vitorias = vitorias_var,
        empates    = empates_var,
        derrotas   = derrotas_var,
        pontuacao  = pontuacao_var
      WHERE participacao.id = participacao_var.id;
    END;
  END LOOP;

  colocacao_loop := 1;
  FOR participacao_var IN SELECT participacao.*
                          FROM participacao
                            JOIN competicao ON competicao.id = participacao.competicao_id
                          ORDER BY participacao.pontuacao DESC
  LOOP
    UPDATE participacao
    SET colocacao = colocacao_loop
    WHERE participacao.id = participacao_var.id;

    colocacao_loop := colocacao_loop + 1;
  END LOOP;

  UPDATE participacao
  SET premio = 1000
  WHERE participacao.colocacao = 1;

  UPDATE participacao
  SET premio = 500
  WHERE participacao.colocacao = 2;

  UPDATE participacao
  SET premio = 200
  WHERE participacao.colocacao = 2;

  RETURN QUERY SELECT participacao.*
               FROM participacao
                 JOIN competicao ON competicao.id = participacao.competicao_id
               ORDER BY participacao.colocacao ASC
               LIMIT 3;
END;
$$ LANGUAGE plpgsql;