package br.com.fiap.reserva_salas.service;

import br.com.fiap.reserva_salas.dto.FeedbackDTO;
import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.dto.SalaDTO;
import br.com.fiap.reserva_salas.dto.UsuarioDTO;
import br.com.fiap.reserva_salas.entity.Feedback;
import br.com.fiap.reserva_salas.entity.Reserva;
import br.com.fiap.reserva_salas.entity.Sala;
import br.com.fiap.reserva_salas.entity.Usuario;
import br.com.fiap.reserva_salas.repository.FeedbackRepository;
import br.com.fiap.reserva_salas.repository.ReservaRepository;
import br.com.fiap.reserva_salas.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired 
    private UsuarioRepository usuarioRepository;
    @Autowired 
    private ReservaRepository reservaRepository;
    @Autowired
    private ReservaService reservaService;
    @Autowired 
    private UsuarioService usuarioService;

    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
        if (feedbackDTO.reserva() == null || feedbackDTO.usuario() == null) {
            throw new IllegalArgumentException("Reserva ou usuario não podem ser null");
          }
       
        Optional<Usuario> usuarioOptional =  usuarioRepository.findById(feedbackDTO.usuario().id());
        Optional<Reserva> reservaOptional = reservaRepository.findById(feedbackDTO.reserva().getId());

        
    	Feedback feedback = new Feedback();
    	feedback.setFeedbackID(feedback.getFeedbackID());
    	feedback.setMensagem(feedbackDTO.mensagem());	
    	feedback.setUsuario(usuarioOptional.get());
    	feedback.setReserva(reservaOptional.get());
   
    
        feedback = feedbackRepository.save(feedback);
        
        return toDTO(feedback);
    }
    
    /*
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
    }*/

    private FeedbackDTO toDTO(Feedback feedback) {
    	
    	FeedbackDTO feedbackDTO = new FeedbackDTO(feedback.getFeedbackID(), reservaService.convertToDTO(feedback.getReserva()), usuarioService.toDTO(feedback.getUsuario()), feedback.getMensagem());
    	return feedbackDTO;
    }

}
