package br.com.fiap.reserva_salas.repository;

import br.com.fiap.reserva_salas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
}