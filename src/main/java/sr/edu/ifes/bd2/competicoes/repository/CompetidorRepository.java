package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Competidor;
import sr.edu.ifes.bd2.competicoes.repository.custom.CompetidorRepositoryCustom;

import java.util.List;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Long>, CompetidorRepositoryCustom {

    public List<Competidor> findTop5ByOrderByParticipacoesColocacaoAsc();

    public List<Competidor> findByParticipacoesCompeticaoId(Long idCompeticao);
}
