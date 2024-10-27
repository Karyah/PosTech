package br.com.fiap.reserva_salas.entity;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity 
public class Administrador extends Pessoa{
	
	private String representanteEmpresa;
	
	public Administrador() {
		super();
	}
	

	public Administrador(UUID id, String nome, String cpf, String email, String telefone, String representanteEmpresa) {
		super();
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setRepresentanteEmpresa(representanteEmpresa);
	}


	public String getRepresentanteEmpresa() {
		return representanteEmpresa;
	}


	public void setRepresentanteEmpresa(String representaEmpresa) {
		this.representanteEmpresa = representaEmpresa;
	}
	
	
}
