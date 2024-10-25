package br.com.fiap.reserva_salas.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record SalaDTO(
        UUID id,

        @NotBlank(message = "Nome não pode estar em branco.")
        String nome,

        TipoSala tipoSala,

        @NotBlank(message = "É obrigatório informar a capacidade da sala.")
        Integer capacidade,

        Boolean disponibilidade
) {
    public SalaDTO(UUID id, String nome, TipoSala tipoSala, Integer capacidade, Boolean disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.tipoSala = (tipoSala != null) ? tipoSala : TipoSala.SALA_DE_REUNIÃO;
        this.capacidade = capacidade;
        this.disponibilidade = (disponibilidade != null) ? disponibilidade : Boolean.TRUE;
    }
}
