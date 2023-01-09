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
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "funcionario", nullable = false)
    private Boolean funcionario;

    @Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
    private Date dataNascimento;

    @ManyToMany(mappedBy = "pessoas")
    private Set<Projeto> projetos = new HashSet<>();

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date criadoEm;

    @Column(columnDefinition = "TIMESTAMP")
    private Date atualizadoEm;

}
