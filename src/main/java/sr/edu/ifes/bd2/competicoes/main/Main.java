package sr.edu.ifes.bd2.competicoes.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        EntityManagerFactory managerFactory = context.getBean(EntityManagerFactory.class);

    }
}
