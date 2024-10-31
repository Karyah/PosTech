package br.com.fiap.reserva_salas.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID feedbackID;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;


    public Feedback() {}

    public Feedback(UUID feedbackID, Usuario usuario, String mensagem, Reserva reserva) {
        this.feedbackID = feedbackID;
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.reserva = reserva;
    }


    public UUID getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(UUID feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}