package sr.edu.ifes.bd2.competicoes.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Evento extends AbstractPersistable<Long> {

    @ManyToOne
    private Competidor competidor1;
    @ManyToOne
    private Competidor competidor2;
    @ManyToOne
    private Competicao competicao;
    @ManyToOne
    private Competidor vencedor;
}
