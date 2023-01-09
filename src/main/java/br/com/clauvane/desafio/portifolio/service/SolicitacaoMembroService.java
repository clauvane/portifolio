package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.model.entity.SolicitacaoMembro;
import br.com.clauvane.desafio.portifolio.repository.SolicitacaoMembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SolicitacaoMembroService {

    @Autowired
    private SolicitacaoMembroRepository solicitacaoMembroRepository;

    @Transactional
    public SolicitacaoMembro saveOrUpdate(SolicitacaoMembro solicitacaoMembro) {
        return solicitacaoMembroRepository.saveAndFlush(solicitacaoMembro);
    }

    @Transactional
    public void delete(SolicitacaoMembro solicitacaoMembro) {
        solicitacaoMembroRepository.delete(solicitacaoMembro);
    }

    public List<SolicitacaoMembro> findAll() {
        return solicitacaoMembroRepository.findAll(Sort.by("pessoa.nome"));
    }

    public Optional<SolicitacaoMembro> findById(UUID id) {
        return solicitacaoMembroRepository.findById(id);
    }

}
