package spring.boot.desafio.desafio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import spring.boot.desafio.desafio1.dto.contatoDTO;
import spring.boot.desafio.desafio1.model.Contato;
import spring.boot.desafio.desafio1.service.contatoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contatos")
public class contatoController {
    
    @Autowired
    private contatoService contatoService;

    @PostMapping
    public ResponseEntity<?> criarContato(@RequestBody @Valid contatoDTO dto) {
        try {
            Contato contato = contatoService.criarContato(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(contato);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
