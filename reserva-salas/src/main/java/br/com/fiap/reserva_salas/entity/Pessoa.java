package br.com.fiap.reserva_salas.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Inheritance
@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	public String nome;
	private String cpf;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(UUID id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
