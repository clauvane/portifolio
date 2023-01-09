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

    @Column(nullable = false, length = 200)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Pessoa gerente;

    @Column(name = "data_inicio", nullable = false, columnDefinition = "DATE")
    private Date dataInicio;

    @Column(name = "data_previsao_fim", nullable = false, columnDefinition = "DATE")
    private Date previsaoTermino;

    @Column(name = "data_fim", columnDefinition = "DATE")
    private Date dataTerminoReal;

    @Column(name = "orcamento", nullable = false)
    private Double orcamento;

    @Column(name = "descricao", nullable = false, length = 5000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusProjeto status;

    @Enumerated(EnumType.STRING)
    @Column(name = "risco", nullable = false)
    private RiscoProjeto risco;

    @ManyToMany
    @JoinTable(name = "membros",
               joinColumns = @JoinColumn(name = "idprojeto"),
               inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    Set<Pessoa> pessoas = new HashSet<>();

    @Column(name = "criado_em", nullable = false, columnDefinition = "TIMESTAMP")
    private Date criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP")
    private Date atualizadoEm;

}
