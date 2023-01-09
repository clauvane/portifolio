package br.com.clauvane.desafio.portifolio.service;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import br.com.clauvane.desafio.portifolio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa saveOrUpdate(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll(Sort.by("nome"));
    }

    public List<Pessoa> findAllFuncionarios() {
        return pessoaRepository.findAllFuncionarios();
    }

    public Optional<Pessoa> findById(UUID id) {
        return pessoaRepository.findById(id);
    }

}
