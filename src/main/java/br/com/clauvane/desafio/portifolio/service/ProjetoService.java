package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import br.com.clauvane.desafio.portifolio.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Transactional
    public Projeto saveOrUpdate(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Transactional
    public void delete(Projeto projeto) {
        projetoRepository.delete(projeto);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll(Sort.by("nome"));
    }

    public Optional<Projeto> findById(UUID id) {
        return projetoRepository.findById(id);
    }

}
