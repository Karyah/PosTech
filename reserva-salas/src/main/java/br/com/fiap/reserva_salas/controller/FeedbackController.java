package br.com.fiap.reserva_salas.controller;

import br.com.fiap.reserva_salas.dto.FeedbackDTO;
import br.com.fiap.reserva_salas.repository.FeedbackRepository;
import br.com.fiap.reserva_salas.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable("id") UUID feedbackID) {
        FeedbackDTO feedbackDTO = feedbackService.getFeedbackById(feedbackID);
        return ResponseEntity.ok(feedbackDTO);
    }

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbacksByReservaId(@PathVariable UUID reservaId) {
        List<FeedbackDTO> feedbacks = feedbackService.getFeedbacksByReservaId(reservaId);
        return ResponseEntity.ok(feedbacks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable UUID id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable UUID id, @RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO updatedFeedback = feedbackService.updateFeedback(id, feedbackDTO);
        if (updatedFeedback != null) {
            return ResponseEntity.ok(updatedFeedback);
        }
        return ResponseEntity.notFound().build();
    }



}