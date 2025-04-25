package spring.boot.desafio.desafio1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.desafio.desafio1.dto.clienteDTO;
import spring.boot.desafio.desafio1.dto.clientesResponseDTO;
import spring.boot.desafio.desafio1.dto.contatoResponseDTO;
import spring.boot.desafio.desafio1.mapper.clienteMapper;
import spring.boot.desafio.desafio1.model.Cliente;
import spring.boot.desafio.desafio1.model.Contato;
import spring.boot.desafio.desafio1.repository.clienteRepository;

@Service
public class clienteService {

    @Autowired
    private clienteRepository clienteRepository;

    public Cliente SalvarCliente(clienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setEmail(dto.getEmail());

        if (dto.getContato() != null && dto.getContato().size() > 0) {
            List<Contato> contatos = dto.getContato().stream().map(c -> {
                Contato contato = new Contato();
                contato.setEmail(c.getEmail());
                contato.setCliente(cliente);
                return contato;
            }).collect(Collectors.toList());
            cliente.setContatos(contatos);
        }
        

        return clienteRepository.save(cliente);
    }

    public List<clientesResponseDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }

    public List<contatoResponseDTO> listarContatosPorClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return cliente.getContatos().stream().map(c -> {
            contatoResponseDTO dto = new contatoResponseDTO();
            dto.setId(c.getId());
            dto.setEmail(c.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }
}
