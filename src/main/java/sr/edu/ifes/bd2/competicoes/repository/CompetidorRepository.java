package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Competidor;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Long> {

}
