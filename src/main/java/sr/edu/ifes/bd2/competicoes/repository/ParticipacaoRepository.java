package sr.edu.ifes.bd2.competicoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sr.edu.ifes.bd2.competicoes.model.Participacao;
import sr.edu.ifes.bd2.competicoes.repository.custom.participacao.ParticipacaoRepositoryCustom;

import java.util.List;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Long>, ParticipacaoRepositoryCustom {

    public List<Participacao> findByCompetidorId(Long id);

    public List<Participacao> findByCompeticaoId(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM criarpodio(:idCompeticao)")
    public List<Participacao> criarPodio( @Param("idCompeticao") Long idCompeticao);

    @Query(nativeQuery = true, value = "SELECT * FROM atualizarpontos(?1, ?2, ?3, ?4)")
    public List<Participacao> atualizarPontos(Long idCompeticao, Integer ptsVitoria, Integer ptsEmpate, Integer ptsDerrota);
}