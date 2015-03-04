package sr.edu.ifes.bd2.competicoes.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Evento extends AbstractPersistable<Long> {

    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor competidor1;
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor competidor2;
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competicao competicao;
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor vencedor;
}
