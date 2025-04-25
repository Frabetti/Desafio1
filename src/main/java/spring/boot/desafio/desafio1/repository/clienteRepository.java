package spring.boot.desafio.desafio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.desafio1.model.Cliente;

public interface clienteRepository extends JpaRepository<Cliente, Long> {
    
}
