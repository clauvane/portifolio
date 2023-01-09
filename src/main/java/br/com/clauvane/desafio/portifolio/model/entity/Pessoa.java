package br.com.clauvane.desafio.portifolio.model.entity;

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

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "funcionario", nullable = false)
    private Boolean funcionario;

    @Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
    private Date dataNascimento;

    @ManyToMany(mappedBy = "pessoas")
    private Set<Projeto> projetos = new HashSet<>();

    @Column(name = "criado_em", nullable = false, columnDefinition = "TIMESTAMP")
    private Date criadoEm;

    @Column(name = "atualizado_em", columnDefinition = "TIMESTAMP")
    private Date atualizadoEm;

}
