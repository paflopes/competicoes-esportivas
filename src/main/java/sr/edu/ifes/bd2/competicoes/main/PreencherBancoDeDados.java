package sr.edu.ifes.bd2.competicoes.main;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sr.edu.ifes.bd2.competicoes.model.Competicao;
import sr.edu.ifes.bd2.competicoes.model.Competidor;
import sr.edu.ifes.bd2.competicoes.model.Participacao;
import sr.edu.ifes.bd2.competicoes.model.PoliticaPontuacao;
import sr.edu.ifes.bd2.competicoes.repository.CompeticaoRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.*;

public class PreencherBancoDeDados {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        final CompeticaoRepository competicaoRepository = context.getBean(CompeticaoRepository.class);

        competicaoRepository.save(competicoes());
    }

    public static List<Competicao> competicoes() {
        final ArrayList<Competicao> competicoes = new ArrayList<>();
        final DataFactory dataFactory = new DataFactory();

        for (int i = 0; i < 2; i++) {
            final Competicao competicao = Competicao.builder()
                    .nome(dataFactory.getRandomWord())
                    .dataInicio(toCalendar(dataFactory.getDateBetween(data(1, 2, 2014), data(27, 2, 2014))))
                    .dataFim(toCalendar(dataFactory.getDateBetween(data(1, 9, 2014), data(27, 9, 2014))))
                    .politicaPontuacao(politicaPontuacao())
                    .build();
            competicao.setParticipacoes(participacoes(competicao));

            competicoes.add(competicao);
        }

        return competicoes;
    }

    public static List<Participacao> participacoes(Competicao competicao) {
        final ArrayList<Participacao> participacoes = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            final Participacao participacao = participacao();
            participacao.setCompeticao(competicao);
            participacoes.add(participacao);
        }

        return participacoes;
    }

    public static Participacao participacao() {
        final DataFactory dataFactory = new DataFactory();

        return Participacao.builder()
                .colocacao((long) dataFactory.getNumberBetween(1, 3))
                .premio((long) dataFactory.getNumberUpTo(100))
                .competidor(competidor())
                .build();
    }

    public static Competidor competidor() {
        final DataFactory dataFactory = new DataFactory();


        return Competidor.builder()
                .nome(dataFactory.getRandomWord())
                .build();
    }

    public static PoliticaPontuacao politicaPontuacao() {
        return PoliticaPontuacao.builder()
                .pontosPorDerrota(0)
                .pontosPorEmpate(1)
                .pontosPorVitoria(3)
                .empatesPermitidos(true)
                .build();
    }

    public static Date data(int dia, int mes, int ano) {
        final Calendar data = Calendar.getInstance();

        data.set(DAY_OF_MONTH, dia);
        data.set(MONTH, mes);
        data.set(YEAR, ano);

        return data.getTime();
    }

    public static Calendar toCalendar(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
