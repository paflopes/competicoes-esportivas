package sr.edu.ifes.bd2.competicoes.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Participacao extends AbstractPersistable<Long> {

    @Column
    private Long colocacao;
    @Column
    private Long premio;
    @ManyToOne(cascade = ALL) @NotNull
    private Competidor competidor;
    @ManyToOne(cascade = ALL) @NotNull
    private Competicao competicao;
}
