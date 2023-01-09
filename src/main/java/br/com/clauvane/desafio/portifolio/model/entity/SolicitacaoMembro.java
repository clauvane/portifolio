package br.com.clauvane.desafio.portifolio.model.entity;

import br.com.clauvane.desafio.portifolio.model.enums.StatusSolicitacaoMembro;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "solicitacao_membro")
public class SolicitacaoMembro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSolicitacaoMembro status;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date criadoEm;

    @Column(columnDefinition = "TIMESTAMP")
    private Date atualizadoEm;

}
