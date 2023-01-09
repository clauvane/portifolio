package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.model.entity.Membro;
import br.com.clauvane.desafio.portifolio.model.entity.MembroId;
import br.com.clauvane.desafio.portifolio.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Transactional
    public Membro saveOrUpdate(Membro membro) {
        return membroRepository.saveAndFlush(membro);
    }

    @Transactional
    public void delete(Membro membro) {
        membroRepository.delete(membro);
    }

    public List<Membro> findAll() {
        return membroRepository.findAll();
    }

    public Optional<Membro> findById(MembroId id) {
        return membroRepository.findById(id);
    }

}
