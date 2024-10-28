package br.com.fiap.reserva_salas.dto;

import br.com.fiap.reserva_salas.entity.Sala;
import br.com.fiap.reserva_salas.entity.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReservaDTO {

  private UUID id;
  private Usuario usuario;
  private Sala sala;
  private LocalDateTime horarioInicio;
  private LocalDateTime horarioFim;
  private double duracao;
  private int qtdParticipantes;

  public ReservaDTO() {
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
