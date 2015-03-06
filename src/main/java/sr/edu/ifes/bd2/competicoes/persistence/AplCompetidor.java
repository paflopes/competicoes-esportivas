package sr.edu.ifes.bd2.competicoes.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.edu.ifes.bd2.competicoes.persistence.repository.CompetidorRepository;

@Service
public class AplCompetidor {

    @Autowired
    private CompetidorRepository competidorRepository;
}
