package spring.boot.desafio.desafio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.desafio1.model.Contato;

public interface contatoRepository extends JpaRepository<Contato, Long> {
    
}
