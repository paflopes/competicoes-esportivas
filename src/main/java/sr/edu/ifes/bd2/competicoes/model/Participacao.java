package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Participacao extends AbstractPersistable<Long> {

    private Long colocacao;
    private String premio;
    private Competidor competidor;
    private Competicao competicao;
}
