package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PoliticaPontuacao extends AbstractPersistable<Long> {

    @Column
    private Integer pontosPorVitoria;
    @Column
    private Integer pontosPorEmpate;
    @Column
    private Integer pontosPorDerrota;
    @Column
    private boolean empatesPermitidos;

    @OneToOne(mappedBy = "politicaPontuacao")
    private Competicao competicao;
}
