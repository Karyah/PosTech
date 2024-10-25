package br.com.fiap.reserva_salas.repository;

import br.com.fiap.reserva_salas.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
