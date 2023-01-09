package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.PortifolioApplication;
import br.com.clauvane.desafio.portifolio.mock.ProjetoMock;
import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PortifolioApplication.class, ProjetoService.class })
@Rollback
class ProjetoServiceTest {

    @Autowired
    private ProjetoService projetoService;

    @Test
    void saveOrUpdate() {
        Projeto projeto = ProjetoMock.getProjeto();

        Projeto projetoBanco = projetoService.saveOrUpdate(projeto);

        assertNotNull(projetoBanco.getId());
        assertEquals(projeto.getNome(), projetoBanco.getNome());
        assertEquals(projeto.getGerenteResponsavel(), projetoBanco.getGerenteResponsavel());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(sdf.format(projeto.getDataInicio()), sdf.format(projetoBanco.getDataInicio()));
        assertEquals(sdf.format(projeto.getPrevisaoTermino()), sdf.format(projetoBanco.getPrevisaoTermino()));
        assertEquals(projeto.getOrcamentoTotal(), projetoBanco.getOrcamentoTotal());
        assertEquals(projeto.getRisco(), projetoBanco.getRisco());
        assertEquals(projeto.getStatus(), projetoBanco.getStatus());
        assertEquals(projeto.getDescricao(), projetoBanco.getDescricao());
    }

    @Test
    void delete() {
        Projeto projeto = ProjetoMock.getProjeto();

        Projeto projetoBanco = projetoService.saveOrUpdate(projeto);

        boolean result;
        try {
            projetoService.delete(projetoBanco);
            result = true;
        } catch (Exception e) {
            result = false;
        }

        assertTrue(result);
    }

    @Test
    void findAll() {
        projetoService.saveOrUpdate(ProjetoMock.getProjeto());
        projetoService.saveOrUpdate(ProjetoMock.getProjeto2());

        List<Projeto> projetos = projetoService.findAll();
        assertFalse(projetos.isEmpty());
        assertEquals(2, projetos.size());
    }

    @Test
    void findById() {
        Projeto projetoMock = ProjetoMock.getProjeto();
        Projeto projetoSaved = projetoService.saveOrUpdate(projetoMock);
        Projeto projetoById = projetoService.findById(projetoSaved.getId()).orElse(null);
        assertNotNull(projetoById);

        assertEquals(projetoMock.getNome(), projetoById.getNome());
        assertEquals(projetoMock.getGerenteResponsavel(), projetoById.getGerenteResponsavel());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(sdf.format(projetoMock.getDataInicio()), sdf.format(projetoById.getDataInicio()));
        assertEquals(sdf.format(projetoMock.getPrevisaoTermino()), sdf.format(projetoById.getPrevisaoTermino()));
        assertEquals(projetoMock.getOrcamentoTotal(), projetoById.getOrcamentoTotal());
        assertEquals(projetoMock.getRisco(), projetoById.getRisco());
        assertEquals(projetoMock.getStatus(), projetoById.getStatus());
        assertEquals(projetoMock.getDescricao(), projetoById.getDescricao());
    }
}