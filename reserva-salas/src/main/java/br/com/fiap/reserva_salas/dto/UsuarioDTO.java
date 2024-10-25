package br.com.fiap.reserva_salas.dto;

import java.util.UUID;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
		
		UUID id,
		@NotBlank(message = "Nome não pode estar em branco")
		String nome, 
		
		@NotBlank
		@CPF(message="CPF inválido")
		String cpf,
		
		@NotBlank
		@Email(message="Email inválido")
		String email
		) {

}
