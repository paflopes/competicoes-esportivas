package sr.edu.ifes.bd2.competicoes.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor @NoArgsConstructor
public class Competidor extends AbstractPersistable<Long> {

    @Column @NotEmpty
    private String nome;

    @OneToMany(mappedBy = "competidor", cascade = ALL)
    private List<Participacao> participacoes;
    @OneToMany(mappedBy = "competidor1", cascade = ALL)
    private List<Evento> eventosCompetidor1;
    @OneToMany(mappedBy = "competidor2", cascade = ALL)
    private List<Evento> eventosCompetidor2;
}
