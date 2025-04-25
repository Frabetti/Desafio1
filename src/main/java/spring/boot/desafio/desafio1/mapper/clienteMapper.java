package spring.boot.desafio.desafio1.mapper;

import java.util.List;
import java.util.stream.Collectors;

import spring.boot.desafio.desafio1.dto.clientesResponseDTO;
import spring.boot.desafio.desafio1.dto.contatoResponseDTO;
import spring.boot.desafio.desafio1.model.Cliente;

public class clienteMapper {
    
    public static clientesResponseDTO toDTO(Cliente cliente) {
        clientesResponseDTO dto = new clientesResponseDTO();
        dto.setId(cliente.getId());
        dto.setEmail(cliente.getEmail());
        
        List<contatoResponseDTO> contatos = cliente.getContatos().stream().map(c -> {
            contatoResponseDTO contatoDTO = new contatoResponseDTO();
            contatoDTO.setId(c.getId());
            contatoDTO.setEmail(c.getEmail());
            return contatoDTO;
        }).collect(Collectors.toList());
        dto.setContatos(contatos);

        return dto;
    }
}
