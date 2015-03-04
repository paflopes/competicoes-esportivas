package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Competidor extends AbstractPersistable<Long> {

    @Column
    private String nome;

    @OneToMany(mappedBy = "competidor")
    private List<Participacao> participacoes;
    @OneToMany(mappedBy = "competidor")
    private List<Evento> eventos;
}
