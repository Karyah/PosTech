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
import java.util.stream.Collectors;

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
    

    public void deleteFeedback(UUID feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    public FeedbackDTO getFeedbackById(UUID feedbackID) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(feedbackID);
        if (feedbackOptional.isPresent()) {
            return toDTO(feedbackOptional.get());
        } else {
            throw new IllegalArgumentException("Feedback não encontrado com ID: " + feedbackID);
        }
    }

    public List<FeedbackDTO> getFeedbacksByReservaId(UUID reservaId) {
        List<Feedback> feedbacks = feedbackRepository.findByReservaId(reservaId);
        return feedbacks.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FeedbackDTO updateFeedback(UUID id, FeedbackDTO feedbackDTO) {
        Optional<Feedback> existingFeedback = feedbackRepository.findById(id);
        if (existingFeedback.isPresent()) {
            Feedback feedback = existingFeedback.get();
            feedback.setMensagem(feedbackDTO.mensagem());
            feedback.setUsuario(usuarioRepository.findById(feedbackDTO.usuario().id()).orElse(null));
            feedback.setReserva(reservaRepository.findById(feedbackDTO.reserva().getId()).orElse(null));
            feedback = feedbackRepository.save(feedback);
            return toDTO(feedback);
        }
        return null;
    }

    private FeedbackDTO toDTO(Feedback feedback) {
    	
    	FeedbackDTO feedbackDTO = new FeedbackDTO(feedback.getFeedbackID(), reservaService.convertToDTO(feedback.getReserva()), usuarioService.toDTO(feedback.getUsuario()), feedback.getMensagem());
    	return feedbackDTO;
    }


}
