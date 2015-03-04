package sr.edu.ifes.bd2.competicoes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "sr.edu.ifes.bd2.competicoes")
public class AppConfig {

}
