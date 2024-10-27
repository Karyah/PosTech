package br.com.fiap.reserva_salas.entity;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity 
public class Administrador extends Pessoa{
	
	private String representanteDaEmpresa;
	
	public Administrador() {
		super();
	}
	

	public Administrador(UUID id, String nome, String cpf, String email, String telefone, String representanteDaEmpresa) {
		super();
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setRepresentanteDaEmpresa(representanteDaEmpresa);
	}


	public String getRepresentanteDaEmpresa() {
		return representanteDaEmpresa;
	}


	public void setRepresentanteDaEmpresa(String representanteDaEmpresa) {
		this.representanteDaEmpresa = representanteDaEmpresa;
	}
	
	
}
