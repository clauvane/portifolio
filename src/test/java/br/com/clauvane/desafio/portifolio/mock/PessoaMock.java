package br.com.clauvane.desafio.portifolio.mock;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;

import java.util.Date;

public class PessoaMock {

    public static Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste 1");
        pessoa.setCpf("123.456.789-01");
        pessoa.setDataNascimento(new Date());
        pessoa.setCriadoEm(new Date());
        pessoa.setFuncionario(false);

        return pessoa;
    }

    public static Pessoa getPessoaFuncionario() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste 2");
        pessoa.setCpf("123.456.789-02");
        pessoa.setDataNascimento(new Date());
        pessoa.setCriadoEm(new Date());
        pessoa.setFuncionario(true);

        return pessoa;
    }

}
