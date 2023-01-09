package br.com.clauvane.desafio.portifolio.model.dto;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import br.com.clauvane.desafio.portifolio.model.enums.StatusSolicitacaoMembro;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
public class SolicitacaoMembroDto {

    private UUID id;

    @NotNull(message = "O projeto é obrigatório.")
    private Projeto projeto;

    @NotNull(message = "A pessoa é obrigatória.")
    private Pessoa pessoa;

    @NotNull(message = "O status é obrigatório.")
    private StatusSolicitacaoMembro status;

    private Date criadoEm;

    private Date atualizadoEm;

}
