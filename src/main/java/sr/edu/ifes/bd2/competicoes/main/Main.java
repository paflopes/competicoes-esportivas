package sr.edu.ifes.bd2.competicoes.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sr.edu.ifes.bd2.competicoes.repository.ParticipacaoRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        final ParticipacaoRepository participacaoRepository = context.getBean(ParticipacaoRepository.class);

        participacaoRepository.findByCompetidorIdDadosDerivadosPreenchidos(1L);
    }
}
