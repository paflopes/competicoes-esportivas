package sr.edu.ifes.bd2.competicoes.repository.custom.participacao;

import sr.edu.ifes.bd2.competicoes.model.Participacao;

import java.util.List;

public interface ParticipacaoRepositoryCustom {

    public List<Participacao> findByCompetidorIdCustom(Long id);
}
