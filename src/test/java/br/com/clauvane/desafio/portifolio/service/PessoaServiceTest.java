package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.PortifolioApplication;
import br.com.clauvane.desafio.portifolio.mock.PessoaMock;
import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {PortifolioApplication.class, PessoaService.class })
@Rollback
class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Test
    void saveOrUpdate() {
        Pessoa pessoa = PessoaMock.getPessoa();

        Pessoa pessoaBanco = pessoaService.saveOrUpdate(pessoa);

        assertNotNull(pessoaBanco.getId());
        assertEquals(pessoa.getNome(), pessoaBanco.getNome());
        assertEquals(pessoa.getCpf(), pessoaBanco.getCpf());
        assertEquals(pessoa.getDataNascimento(), pessoaBanco.getDataNascimento());
    }

    @Test
    void delete() {
        Pessoa pessoa = PessoaMock.getPessoa();

        Pessoa pessoaBanco = pessoaService.saveOrUpdate(pessoa);

        boolean result;
        try {
            pessoaService.delete(pessoaBanco);
            result = true;
        } catch (Exception e) {
            result = false;
        }

        assertTrue(result);
    }

    @Test
    void findAll() {
        pessoaService.saveOrUpdate(PessoaMock.getPessoa());
        pessoaService.saveOrUpdate(PessoaMock.getPessoaFuncionario());

        List<Pessoa> pessoas = pessoaService.findAll();
        assertFalse(pessoas.isEmpty());
        assertEquals(2, pessoas.size());
    }

    @Test
    void findAllFuncionarios() {
        pessoaService.saveOrUpdate(PessoaMock.getPessoa());
        pessoaService.saveOrUpdate(PessoaMock.getPessoaFuncionario());

        List<Pessoa> pessoas = pessoaService.findAllFuncionarios();
        assertFalse(pessoas.isEmpty());
        assertEquals(1, pessoas.size());
    }

    @Test
    void findById() {
        Pessoa pessoaMock = PessoaMock.getPessoa();
        Pessoa pessoaSaved = pessoaService.saveOrUpdate(pessoaMock);
        Pessoa pessoaById = pessoaService.findById(pessoaSaved.getId()).orElse(null);
        assertNotNull(pessoaById);
        assertEquals(pessoaMock.getNome(), pessoaById.getNome());
        assertEquals(pessoaMock.getCpf(), pessoaById.getCpf());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(sdf.format(pessoaMock.getDataNascimento()), sdf.format(pessoaById.getDataNascimento()));
    }
}