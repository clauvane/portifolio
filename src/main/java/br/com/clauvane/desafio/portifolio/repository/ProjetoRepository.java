package br.com.clauvane.desafio.portifolio.repository;

import br.com.clauvane.desafio.portifolio.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {

}
