package br.com.fiap.reserva_salas.service;

import br.com.fiap.reserva_salas.dto.FeedbackDTO;
import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.entity.Feedback;
import br.com.fiap.reserva_salas.entity.Reserva;
import br.com.fiap.reserva_salas.entity.Usuario;
import br.com.fiap.reserva_salas.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO, Reserva reserva, Usuario usuario) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackID(UUID.randomUUID());
        feedback.setMensagem(feedbackDTO.getMensagem());
        feedback.setReserva(reserva);
        feedback.setUsuario(usuario);

        feedback = feedbackRepository.save(feedback);
        return new FeedbackDTO(feedback.getFeedbackID(), feedback.getReserva(), feedback.getMensagem(), feedback.getUsuario());
    }

    public void deleteFeedback(UUID feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    public FeedbackDTO getFeedbackById(UUID feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback não encontrado"));
        return new FeedbackDTO(feedback.getFeedbackID(), feedback.getReserva(), feedback.getMensagem(), feedback.getUsuario());
    }

    public List<FeedbackDTO> getFeedbacksByReservationId(UUID reservaId) {
        List<Feedback> feedbacks = feedbackRepository.findByReservaId(reservaId);
        return feedbacks.stream()
                .map(feedback -> new FeedbackDTO(feedback.getFeedbackID(), feedback.getReserva(), feedback.getMensagem(), feedback.getUsuario()))
                .collect(Collectors.toList());
    }



}
