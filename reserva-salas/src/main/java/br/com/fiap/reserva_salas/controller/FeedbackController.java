package br.com.fiap.reserva_salas.controller;

import br.com.fiap.reserva_salas.dto.FeedbackDTO;
import br.com.fiap.reserva_salas.repository.FeedbackRepository;
import br.com.fiap.reserva_salas.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO createdFeedback = feedbackService.createFeedback(feedbackDTO);
        return ResponseEntity.ok(createdFeedback);
    }
    /*

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable UUID id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable UUID id) {
        FeedbackDTO feedbackDTO = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedbackDTO);
    }

    @GetMapping("/reservas/{reservaId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbacksByReservation(@PathVariable UUID reservaId) {
        List<FeedbackDTO> feedbacks = feedbackService.getFeedbacksByReservationId(reservaId);
        return ResponseEntity.ok(feedbacks);
    }
    */
}