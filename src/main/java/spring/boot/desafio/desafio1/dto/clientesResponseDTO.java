package spring.boot.desafio.desafio1.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class clientesResponseDTO {
    
    private Long id;
    private String email;
    private List<contatoResponseDTO> contatos;
}
