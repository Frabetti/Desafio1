package spring.boot.desafio.desafio1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class contatoResponseDTO {

    private Long id;
    private String email;
    private Long clienteId;
}
