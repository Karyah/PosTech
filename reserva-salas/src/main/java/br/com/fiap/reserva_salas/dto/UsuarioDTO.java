package br.com.fiap.reserva_salas.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
		UUID id,
		@NotBlank(message = "Nome não pode estar em branco")
		String nome, 
		String cpf) {

}
