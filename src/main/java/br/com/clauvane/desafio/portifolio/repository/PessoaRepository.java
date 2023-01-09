package br.com.clauvane.desafio.portifolio.repository;

import br.com.clauvane.desafio.portifolio.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query("from Pessoa p where p.funcionario = true order by p.nome")
    List<Pessoa> findAllFuncionarios();

}
