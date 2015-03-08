CREATE OR REPLACE FUNCTION atualizarPontos(idCompeticao BIGINT, ptVitoria INTEGER, ptEmpate INTEGER, ptDerrota INTEGER) RETURNS SETOF participacao AS
$$
DECLARE
  politica politicapontuacao%ROWTYPE;
BEGIN
  SELECT politicapontuacao.* INTO politica
  FROM politicapontuacao
    JOIN competicao ON politicapontuacao.id = competicao.politicapontuacao_id
  WHERE competicao.id = idCompeticao;

  UPDATE politicapontuacao
  SET pontosporvitoria = ptVitoria,
    pontosporempate = ptEmpate,
    pontosporderrota = ptDerrota
  WHERE politicapontuacao.id = politica.id;

  PERFORM criarpodio(idCompeticao);

  RETURN QUERY SELECT participacao.*
  FROM participacao
    JOIN competicao ON competicao.id = participacao.competicao_id
  WHERE competicao.id = idCompeticao;
END;
$$ LANGUAGE plpgsql;