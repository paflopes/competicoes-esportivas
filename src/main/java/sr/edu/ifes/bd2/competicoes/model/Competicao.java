package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Competicao extends AbstractPersistable<Long> {

    private String nome;
    private Calendar dataInicio;
    private Calendar dataFim;
    private PoliticaPontuacao politicaPontuacao;
}
