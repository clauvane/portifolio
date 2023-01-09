package br.com.clauvane.desafio.portifolio.mock;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import br.com.clauvane.desafio.portifolio.model.enums.RiscoProjeto;
import br.com.clauvane.desafio.portifolio.model.enums.StatusProjeto;

import java.util.Date;

public class ProjetoMock {

    public static Projeto getProjeto() {
        Projeto projeto = new Projeto();
        projeto.setNome("Teste 1");
        projeto.setDataInicio(new Date());
        projeto.setPrevisaoTermino(new Date());
        projeto.setGerenteResponsavel("Teste Gerente");
        projeto.setOrcamentoTotal("1");
        projeto.setStatus(StatusProjeto.EM_ANALISE);
        projeto.setRisco(RiscoProjeto.BAIXO);
        projeto.setDescricao("lorem ipsulum");
        projeto.setCriadoEm(new Date());

        return projeto;
    }

    public static Projeto getProjeto2() {
        Projeto projeto = new Projeto();
        projeto.setNome("Teste 2");
        projeto.setDataInicio(new Date());
        projeto.setPrevisaoTermino(new Date());
        projeto.setGerenteResponsavel("Teste Gerente 2");
        projeto.setOrcamentoTotal("2");
        projeto.setStatus(StatusProjeto.ANALISE_APROVADA);
        projeto.setRisco(RiscoProjeto.BAIXO);
        projeto.setDescricao("lorem ipsulum");
        projeto.setCriadoEm(new Date());

        return projeto;
    }

}
