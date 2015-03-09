package sr.edu.ifes.bd2.competicoes.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.DATE;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor @NoArgsConstructor
public class Competicao extends AbstractPersistable<Long> {

    @Column @NotEmpty
    private String nome;
    @Temporal(DATE) @NotEmpty
    private Calendar dataInicio;
    @Temporal(DATE) @NotEmpty
    private Calendar dataFim;
    @OneToOne(orphanRemoval = true, cascade = ALL) @NotNull
    private PoliticaPontuacao politicaPontuacao;

    //    Para permitir consultas por esse lado do relacionamento.
    @OneToMany(mappedBy = "competicao", cascade = ALL)
    private List<Participacao> participacoes;
    @OneToMany(mappedBy = "competicao", cascade = ALL)
    private List<Evento> eventos;
}
