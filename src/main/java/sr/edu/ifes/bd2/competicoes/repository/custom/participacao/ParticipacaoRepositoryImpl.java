package sr.edu.ifes.bd2.competicoes.repository.custom.participacao;

import sr.edu.ifes.bd2.competicoes.model.Participacao;
import sr.edu.ifes.bd2.competicoes.repository.ParticipacaoRepository;

import javax.inject.Inject;
import java.util.List;

public class ParticipacaoRepositoryImpl implements ParticipacaoRepositoryCustom {

    @Inject
    private ParticipacaoRepository participacaoRepository;

    @Override
    public List<Participacao> findByCompetidorIdCustom(Long id) {
        final List<Participacao> participacoes = participacaoRepository.findByCompetidorId(id);


        return null;
    }
}
