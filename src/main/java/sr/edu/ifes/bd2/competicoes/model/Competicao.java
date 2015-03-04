package sr.edu.ifes.bd2.competicoes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Competicao extends AbstractPersistable<Long> {

    @Column
    private String nome;
    @Temporal(DATE)
    private Calendar dataInicio;
    @Temporal(DATE)
    private Calendar dataFim;
    @OneToOne(orphanRemoval = true)
    private PoliticaPontuacao politicaPontuacao;

//    Para permitir consultas por esse lado do relacionamento.
    @OneToMany(mappedBy = "competicao")
    private List<Participacao> participacoes;
    @OneToMany(mappedBy = "competicao")
    private List<Evento> eventos;
}
