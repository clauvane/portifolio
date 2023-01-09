package br.com.clauvane.desafio.portifolio.model.dto;

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
    @Size(max = 100, message = "O tamanho máximo permitido é de 100 caracteres.")
    private String nome;

    @NotBlank(message = "O gerente responsável é obrigatório.")
    private String gerenteResponsavel;

    @NotNull(message = "A data de Início é obrigatória.")
    private Date dataInicio;

    @NotNull(message = "A previsão de Término é obrigatória.")
    private Date previsaoTermino;

    private Date dataTerminoReal;

    @NotBlank(message = "O orçamento total é obrigatório.")
    private String orcamentoTotal;

    @Size(max = 5000, message = "O tamanho máximo permitido é de 5000 caracteres.")
    private String descricao;

    @NotNull(message = "O status é obrigatório.")
    private StatusProjeto status;

    @NotNull(message = "O risco é obrigatório.")
    private RiscoProjeto risco;

    private Date criadoEm;

    private Date atualizadoEm;

}
