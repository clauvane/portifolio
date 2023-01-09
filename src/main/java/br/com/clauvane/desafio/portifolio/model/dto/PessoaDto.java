package br.com.clauvane.desafio.portifolio.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
public class PessoaDto {

    private UUID id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O tamanho máximo permitido é de 100 caracteres.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(max = 14, message = "O tamanho máximo permitido é de 14 caracteres.")
    private String cpf;

    @NotNull(message = "A data de Nascimento é obrigatória.")
    private Date dataNascimento;

    @NotNull(message = "O funcionário é obrigatório.")
    private Boolean funcionario;

    private Date criadoEm;

    private Date atualizadoEm;

}
