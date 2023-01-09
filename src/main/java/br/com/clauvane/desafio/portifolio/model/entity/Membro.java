package br.com.clauvane.desafio.portifolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "membros")
public class Membro {

    @EmbeddedId
    private MembroId membroId;

}
