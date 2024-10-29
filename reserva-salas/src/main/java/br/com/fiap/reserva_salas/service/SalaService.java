package br.com.fiap.reserva_salas.service;

import br.com.fiap.reserva_salas.controller.exception.ControllerNotFoundException;
import br.com.fiap.reserva_salas.dto.SalaDTO;
import br.com.fiap.reserva_salas.entity.Sala;
import br.com.fiap.reserva_salas.repository.SalaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repo;

    public Page<SalaDTO> findAll(Pageable pageable) {
        //var salas = repo.findAll();
        Page<Sala> salas = repo.findAll(pageable);
        return salas.map(this::toSalaDTO);
    }

    public SalaDTO findById(UUID id){
        var sala = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Sala não encontrada."));
        return toSalaDTO(sala);
    }

    public SalaDTO save(SalaDTO salaDTO){
        Sala sala = toSala(salaDTO);
        sala = repo.save(sala);
        return toSalaDTO(sala);
    }

    // Update
    public SalaDTO update(UUID id, SalaDTO salaDTO){

        try {
            Sala buscaSala = repo.getReferenceById(id);
            buscaSala.setNome(salaDTO.nome());
            buscaSala.setTipoSala(salaDTO.tipoSala());
            buscaSala.setcapacidade(salaDTO.capacidade());
            buscaSala.setDisponibilidade(salaDTO.disponibilidade());
            buscaSala = repo.save(buscaSala);

            return toSalaDTO(buscaSala);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Sala não encontrada.");
        }
    }

    // Delete
    public void delete(UUID id){
        repo.deleteById(id);
    }

    public SalaDTO toSalaDTO(Sala sala){
        return new SalaDTO(
                sala.getId(),
                sala.getNome(),
                sala.getTipoSala(),
                sala.getcapacidade(),
                sala.getDisponibilidade());
    }

    public Sala toSala(SalaDTO salaDTO){
        return new Sala(
                salaDTO.id(),
                salaDTO.nome(),
                salaDTO.tipoSala(),
                salaDTO.capacidade(),
                salaDTO.disponibilidade());

    }
}
