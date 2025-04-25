package spring.boot.desafio.desafio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.desafio.desafio1.dto.clienteDTO;
import spring.boot.desafio.desafio1.dto.clientesResponseDTO;
import spring.boot.desafio.desafio1.dto.contatoResponseDTO;
import spring.boot.desafio.desafio1.model.Cliente;
import spring.boot.desafio.desafio1.service.clienteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clientes")
public class clienteController {
    
    @Autowired
    private clienteService clienteService;
    
    @PostMapping()
    public ResponseEntity<Cliente> criarCliente(@RequestBody clienteDTO dto) {
        Cliente clienteSalvo = clienteService.SalvarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<clientesResponseDTO>> listarTodosClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<contatoResponseDTO>> listarContatosPorClienteId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarContatosPorClienteId(id));
    }
}
