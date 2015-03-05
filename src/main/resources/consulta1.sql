SELECT competidor.id competidor, pp.pontosporvitoria * count(competidor.id) pontuacao
FROM politicapontuacao pp
  JOIN competicao ON pp.id = competicao.politicapontuacao_id
  JOIN evento e ON competicao.id = e.competicao_id
  JOIN competidor ON competidor.id = e.vencedor_id
GROUP BY competidor.id, pp.pontosporvitoria

UNION

SELECT competidor.id competidor, pp.pontosporempate * count(competidor.id) pontuacao
FROM politicapontuacao pp
  JOIN competicao ON pp.id = competicao.politicapontuacao_id
  JOIN evento e ON competicao.id = e.competicao_id
  JOIN competidor
    ON (competidor.id = e.competidor1_id OR competidor.id = e.competidor2_id)
       AND e.vencedor_id IS NULL
GROUP BY competidor.id, pp.pontosporempate

UNION

SELECT competidor.id competidor, pp.pontosporderrota * count(competidor.id) pontuacao
FROM politicapontuacao pp
  JOIN competicao ON pp.id = competicao.politicapontuacao_id
  JOIN evento e ON competicao.id = e.competicao_id
  JOIN competidor
    ON competidor.id != e.vencedor_id
       AND (competidor.id = e.competidor1_id OR competidor.id = e.competidor2_id)
GROUP BY competidor.id, pp.pontosporderrota;