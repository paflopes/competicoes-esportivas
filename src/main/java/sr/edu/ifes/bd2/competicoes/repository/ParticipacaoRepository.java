package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Participacao;
import sr.edu.ifes.bd2.competicoes.repository.custom.participacao.ParticipacaoRepositoryCustom;

import java.util.List;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Long>, ParticipacaoRepositoryCustom {

    public List<Participacao> findByCompetidorId(Long id);
}