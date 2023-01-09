package br.com.clauvane.desafio.portifolio.model.enums;

public enum StatusSolicitacaoMembro {

    SOLICITADO(1, "Solicitado"),
    APROVADO(2, "Aprovado"),
    REPROVADO(3, "Reprovado");

    private Integer id;
    private String descricao;

    private StatusSolicitacaoMembro(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
