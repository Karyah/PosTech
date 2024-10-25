package br.com.fiap.reserva_salas.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	List<ValidationMessage> mensagens = new ArrayList<>();
	
	public List<ValidationMessage> getMensagens(){
		return mensagens;
	}
	
	public void addMensagens(String campo, String mensagem) {
		mensagens.add(new ValidationMessage(campo,mensagem));
	}
}
