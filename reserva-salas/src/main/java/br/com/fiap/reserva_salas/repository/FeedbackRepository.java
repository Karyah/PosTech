package br.com.fiap.reserva_salas.repository;

import br.com.fiap.reserva_salas.dto.FeedbackDTO;
import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findByReservaId(UUID reservaId);
}
