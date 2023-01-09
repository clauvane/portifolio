package br.com.clauvane.desafio.portifolio.model.entity;

import br.com.clauvane.desafio.portifolio.model.enums.RiscoProjeto;
import br.com.clauvane.desafio.portifolio.model.enums.StatusProjeto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String gerenteResponsavel;

    @Column(name = "data_inicio", nullable = false, columnDefinition = "DATE")
    private Date dataInicio;

    @Column(name = "data_fim", nullable = false, columnDefinition = "DATE")
    private Date previsaoTermino;

    @Column(name = "data_fim_real", columnDefinition = "DATE")
    private Date dataTerminoReal;

    @Column(name = "orcamento_total", nullable = false)
    private String orcamentoTotal;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProjeto status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiscoProjeto risco;

    @ManyToMany
    @JoinTable(name = "membros",
               joinColumns = @JoinColumn(name = "idprojeto"),
               inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    Set<Pessoa> pessoas = new HashSet<>();

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date criadoEm;

    @Column(columnDefinition = "TIMESTAMP")
    private Date atualizadoEm;

}
