package br.com.fiap.reserva_salas.controller.exception;

public class ValidationMessage {
	
	private String campo;
	private String mensagem;
	
	public ValidationMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ValidationMessage(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
