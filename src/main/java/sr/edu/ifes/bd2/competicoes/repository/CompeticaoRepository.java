package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Competicao;

import java.util.List;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {

}
