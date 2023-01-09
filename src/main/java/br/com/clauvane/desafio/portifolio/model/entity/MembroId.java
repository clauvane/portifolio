package br.com.clauvane.desafio.portifolio.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Data
@Embeddable
public class MembroId implements Serializable {

    @OneToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

}
