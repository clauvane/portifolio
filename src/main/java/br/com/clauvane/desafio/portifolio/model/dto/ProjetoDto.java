package br.com.clauvane.desafio.portifolio.model.dto;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import br.com.clauvane.desafio.portifolio.model.enums.RiscoProjeto;
import br.com.clauvane.desafio.portifolio.model.enums.StatusProjeto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
public class ProjetoDto {

    private UUID id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 200, message = "O tamanho máximo permitido é de 200 caracteres.")
    private String nome;

    @NotNull(message = "O gerente é obrigatório.")
    private Pessoa gerente;

    @NotNull(message = "A data de Início é obrigatória.")
    private Date dataInicio;

    @NotNull(message = "A previsão de Término é obrigatória.")
    private Date previsaoTermino;

    private Date dataTerminoReal;

    @NotBlank(message = "O orçamento é obrigatório.")
    private Double orcamento;

    @Size(max = 5000, message = "O tamanho máximo permitido é de 5000 caracteres.")
    private String descricao;

    @NotNull(message = "O status é obrigatório.")
    private StatusProjeto status;

    @NotNull(message = "O risco é obrigatório.")
    private RiscoProjeto risco;

    private Date criadoEm;

    private Date atualizadoEm;

}
