CREATE OR REPLACE FUNCTION criarPodio(idCompeticao bigint) RETURNS VOID AS
$$
DECLARE
  competicaoAtual competicao%ROWTYPE;
  idVencedor BIGINT;
  nVencedor INTEGER;
  vencedores CURSOR FOR SELECT count(evento.vencedor_id) vencedores
                        FROM competicao
                          JOIN evento ON competicao.id = evento.competicao_id
                        GROUP BY evento.vencedor_id
                        ORDER BY vencedores DESC;
BEGIN
  SELECT * INTO competicaoAtual FROM competicao WHERE competicao.id = idCompeticao;

  IF competicaoAtual IS NULL THEN
    RAISE EXCEPTION 'Competição não encontrada';
  END IF;

  nVencedor = 1;
  FOR idVencedor IN vencedores LOOP
    UPDATE participacao
    SET participacao.colocacao = nVencedor
    WHERE participacao.competidor_id = idVencedor;

    nVencedor = nVencedor + 1;
  END LOOP;

END;
$$ LANGUAGE plpgsql;