package br.com.fiap.reserva_salas.dto;


import br.com.fiap.reserva_salas.entity.Reserva;
import br.com.fiap.reserva_salas.entity.Usuario;
import jakarta.persistence.*;

import java.util.UUID;


public class FeedbackDTO {

    private UUID feedbackID;
    private ReservaDTO reserva;
    private String mensagem;
    private UsuarioDTO usuario;


    public FeedbackDTO(UUID feedbackID, ReservaDTO reserva, String mensagem, UsuarioDTO usuario) {
        this.feedbackID = feedbackID;
        this.reserva = reserva;
        this.mensagem = mensagem;
        this.usuario = usuario;
    }



    public UUID getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(UUID feedbackID) {
        this.feedbackID = feedbackID;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

}
