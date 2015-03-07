package sr.edu.ifes.bd2.competicoes.repository.custom.participacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sr.edu.ifes.bd2.competicoes.model.Evento;
import sr.edu.ifes.bd2.competicoes.model.Participacao;
import sr.edu.ifes.bd2.competicoes.repository.EventoRepository;
import sr.edu.ifes.bd2.competicoes.repository.ParticipacaoRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class ParticipacaoRepositoryImpl implements ParticipacaoRepositoryCustom {

    @Autowired
    private ParticipacaoRepository participacaoRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Participacao> findByCompetidorIdDadosDerivadosPreenchidos(Long id) {
        final List<Participacao> participacoes = participacaoRepository.findByCompetidorId(id);

        preencherDadosDerivados(participacoes);

        return participacoes;
    }

    private void preencherDadosDerivados(List<Participacao> participacoes) {
        for (Participacao participacao : participacoes) {
            final List<Evento> eventos = eventoRepository.findByCompetidorIdAndCompeticaoId(participacao.getCompetidor().getId(), participacao.getCompeticao().getId());
            Integer vitorias = 0;
            Integer empates = 0;
            Integer derrotas = 0;
            Integer pontuacao;

            for (Evento evento : eventos) {
                if (evento.getVencedor().equals(participacao.getCompetidor()))
                    vitorias++;
                else if (!evento.getVencedor().equals(participacao.getCompetidor()))
                    derrotas++;
                else if (evento.getVencedor() == null && evento.getCompeticao().getPoliticaPontuacao().isEmpatesPermitidos())
                    empates++;
            }

            pontuacao = vitorias * participacao.getCompeticao().getPoliticaPontuacao().getPontosPorVitoria();
            pontuacao += empates * participacao.getCompeticao().getPoliticaPontuacao().getPontosPorEmpate();
            pontuacao += derrotas * participacao.getCompeticao().getPoliticaPontuacao().getPontosPorDerrota();

            participacao.setVitorias(vitorias);
            participacao.setEmpates(empates);
            participacao.setDerrotas(derrotas);
            participacao.setPontuacao(pontuacao);
        }

        ordernarPorPontuacaoDesc(participacoes);

        preencherColocacao(participacoes);
    }

    private void ordernarPorPontuacaoDesc(List<Participacao> participacoes) {
        Collections.sort(participacoes, new Comparator<Participacao>() {
            @Override
            public int compare(Participacao p1, Participacao p2) {
                if (p1.getPontuacao().equals(p2.getPontuacao()))
                    return 0;
                else if (p1.getPontuacao() > p2.getPontuacao())
                    return -1;
                else
                    return 1;
            }
        });
    }

    private void preencherColocacao(List<Participacao> participacoes) {
        Long colocacao = 1L;
        for (Participacao participacao : participacoes) {
            participacao.setColocacao(colocacao);
            colocacao++;
        }
    }
}
