package br.com.fiap.reserva_salas.entity;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class Supervisor extends Pessoa{
	
	private String periodoTrabalho;
	private String secaoDeTrabalho;
		
	public Supervisor() {
		super();
	}
	

	public Supervisor(UUID id, String nome, String cpf, String email, String telefone, String periodoTrabalho, String secaoDeTrabalho) {
		super();
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setPeriodoTrabalho(periodoTrabalho);
		setSecaoDeTrabalho(secaoDeTrabalho);
}

	public String getPeriodoTrabalho() {
		return periodoTrabalho;
	}

	public void setPeriodoTrabalho(String periodoTrabalho) {
		this.periodoTrabalho = periodoTrabalho;
	}
	
	public String getSecaoDeTrabalho() {
		return secaoDeTrabalho;
	}

	public void setSecaoDeTrabalho(String secaoDeTrabalho) {
		this.secaoDeTrabalho = secaoDeTrabalho;
	}
	
	
	
	
}