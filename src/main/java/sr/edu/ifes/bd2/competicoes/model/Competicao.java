package sr.edu.ifes.bd2.competicoes.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.DATE;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Competicao extends AbstractPersistable<Long> {

    @Column
    private String nome;
    @Temporal(DATE)
    private Calendar dataInicio;
    @Temporal(DATE)
    private Calendar dataFim;
    @OneToOne(orphanRemoval = true, cascade = ALL)
    private PoliticaPontuacao politicaPontuacao;

    //    Para permitir consultas por esse lado do relacionamento.
    @OneToMany(mappedBy = "competicao", cascade = ALL)
    private List<Participacao> participacoes;
    @OneToMany(mappedBy = "competicao", cascade = ALL)
    private List<Evento> eventos;
}
