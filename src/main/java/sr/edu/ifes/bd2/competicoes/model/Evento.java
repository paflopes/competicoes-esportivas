package sr.edu.ifes.bd2.competicoes.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor @NoArgsConstructor
public class Evento extends AbstractPersistable<Long> {

    @NotNull @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor competidor1;
    @NotNull @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor competidor2;
    @NotNull @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competicao competicao;
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH})
    private Competidor vencedor;
}
