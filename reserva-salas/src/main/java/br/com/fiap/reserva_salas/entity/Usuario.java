package br.com.fiap.reserva_salas.entity;

import java.util.UUID;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends Pessoa{

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(UUID id, String nome, String cpf) {
		super();
		setId(id);
		setCpf(cpf);
		this.nome = nome;
	}

	
}
