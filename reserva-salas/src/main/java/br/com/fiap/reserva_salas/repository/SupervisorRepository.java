package br.com.fiap.reserva_salas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.reserva_salas.entity.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, UUID>{

}
