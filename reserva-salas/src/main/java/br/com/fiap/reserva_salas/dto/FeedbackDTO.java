package br.com.fiap.reserva_salas.dto;

import java.util.UUID;

public record FeedbackDTO(
		UUID id,
		ReservaDTO reserva,
		UsuarioDTO usuario, 
		String mensagem) {
	
	public FeedbackDTO(UUID id, ReservaDTO reserva, UsuarioDTO usuario, String mensagem) {
		this.id = id;
		this.usuario = usuario;
		this.reserva = reserva;
		this.mensagem = mensagem;
	}
}
