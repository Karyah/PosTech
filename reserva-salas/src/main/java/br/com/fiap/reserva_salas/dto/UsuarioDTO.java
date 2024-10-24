package br.com.fiap.reserva_salas.dto;

import java.util.UUID;

public record UsuarioDTO(UUID id, String nome, String cpf) {

}
