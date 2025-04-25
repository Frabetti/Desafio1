package spring.boot.desafio.desafio1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import spring.boot.desafio.desafio1.dto.contatoDTO;
import spring.boot.desafio.desafio1.model.Cliente;
import spring.boot.desafio.desafio1.model.Contato;
import spring.boot.desafio.desafio1.repository.clienteRepository;
import spring.boot.desafio.desafio1.repository.contatoRepository;

@Service
public class contatoService {
    
    @Autowired
    private contatoRepository contatoRepository;
    
    @Autowired
    private clienteRepository clienteRepository;

    public Contato criarContato(contatoDTO dto) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getClienteId());
        if(clienteOptional.isEmpty()) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }

        Contato contato = new Contato();
        contato.setEmail(dto.getEmail());
        contato.setCliente(clienteOptional.get());
        return contatoRepository.save(contato);
    }
}
