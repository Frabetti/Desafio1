package spring.boot.desafio.desafio1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class contatoDTO {

    @NotBlank(message = "Email é obrigatório")
    private String email;
    private Long clienteId;
}
