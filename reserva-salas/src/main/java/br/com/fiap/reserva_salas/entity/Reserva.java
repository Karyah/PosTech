package br.com.fiap.reserva_salas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;

  @ManyToOne(optional = false)
  @JoinColumn(name = "sala_id", nullable = false)
  private Sala sala;

  @Column(nullable = false)
  private LocalDateTime horarioInicio;

  @Column(nullable = false)
  private LocalDateTime horarioFim;

  @Column(nullable = false)
  private double duracao;

  @Column(nullable = false)
  private int qtdParticipantes;


  public Reserva() {
  }

  public Reserva(Usuario usuario, Sala sala, LocalDateTime horarioInicio, LocalDateTime horarioFim, double duracao, int qtdParticipantes) {
    this.usuario = usuario;
    this.sala = sala;
    this.horarioInicio = horarioInicio;
    this.horarioFim = horarioFim;
    this.duracao = duracao;
    this.qtdParticipantes = qtdParticipantes;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Sala getSala() {
    return sala;
  }

  public void setSala(Sala sala) {
    this.sala = sala;
  }

  public LocalDateTime getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(LocalDateTime horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public LocalDateTime getHorarioFim() {
    return horarioFim;
  }

  public void setHorarioFim(LocalDateTime horarioFim) {
    this.horarioFim = horarioFim;
  }

  public double getDuracao() {
    return duracao;
  }

  public void setDuracao(double duracao) {
    this.duracao = duracao;
  }

  public int getQtdParticipantes() {
    return qtdParticipantes;
  }

  public void setQtdParticipantes(int qtdParticipantes) {
    this.qtdParticipantes = qtdParticipantes;
  }
}
