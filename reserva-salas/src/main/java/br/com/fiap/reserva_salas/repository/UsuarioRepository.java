package br.com.fiap.reserva_salas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.reserva_salas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
