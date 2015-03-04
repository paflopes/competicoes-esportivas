package sr.edu.ifes.bd2.competicoes.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sr.edu.ifes.bd2.competicoes.model.Competidor;
import sr.edu.ifes.bd2.competicoes.repository.CompetidorRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        CompetidorRepository repository = context.getBean(CompetidorRepository.class);
        Competidor competidor = Competidor.builder().nome("Flamengo").build();

        repository.save(competidor);
    }
}
