package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Evento;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("select e from Evento e where (e.competidor1.id = ?1 or e.competidor2.id = ?1) and e.competicao.id = ?2")
    public List<Evento> findByCompetidorIdAndCompeticaoId(Long idCompetidor, Long idCompeticao);
}