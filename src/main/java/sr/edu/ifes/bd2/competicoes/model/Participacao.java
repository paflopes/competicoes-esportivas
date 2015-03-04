package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Participacao extends AbstractPersistable<Long> {

    @Column
    private Long colocacao;
    @Column
    private Long premio;
    @ManyToOne
    private Competidor competidor;
    @ManyToOne
    private Competicao competicao;
}
