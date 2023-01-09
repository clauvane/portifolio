package br.com.clauvane.desafio.portifolio.repository;

import br.com.clauvane.desafio.portifolio.model.entity.Membro;
import br.com.clauvane.desafio.portifolio.model.entity.MembroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, MembroId> {

}
