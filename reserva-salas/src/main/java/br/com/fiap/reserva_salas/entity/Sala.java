package br.com.fiap.reserva_salas.entity;

import br.com.fiap.reserva_salas.dto.TipoSala;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
//@Table(name = "tb_sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoSala tipoSala;
    private Integer capacidade;
    private Boolean disponibilidade;

    public Sala() {};

    public Sala(UUID id, String nome, TipoSala tipoSala, Integer capacidade, Boolean disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.tipoSala = tipoSala;
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public Integer getcapacidade() {
        return capacidade;
    }

    public void setcapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoSala='" + tipoSala + '\'' +
                ", capacidade=" + capacidade +
                ", disponibilidade='" + disponibilidade + '\'' +
                '}';
    }
}
