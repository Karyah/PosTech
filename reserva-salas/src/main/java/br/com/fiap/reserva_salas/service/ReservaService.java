package br.com.fiap.reserva_salas.service;

import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.entity.Reserva;
import br.com.fiap.reserva_salas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {

  private final ReservaRepository reservaRepository;

  @Autowired
  public ReservaService(ReservaRepository reservaRepository) {
    this.reservaRepository = reservaRepository;
  }

  public ReservaDTO create(ReservaDTO reservaDTO) {
    Reserva reserva = new Reserva();
    reserva.setUsuario(reservaDTO.getUsuario());
    reserva.setSala(reservaDTO.getSala());
    reserva.setHorarioInicio(reservaDTO.getHorarioInicio());
    reserva.setHorarioFim(reservaDTO.getHorarioFim());
    reserva.setDuracao(reservaDTO.getDuracao());
    reserva.setQtdParticipantes(reservaDTO.getQtdParticipantes());
    reserva = reservaRepository.save(reserva);
    return convertToDTO(reserva);
  }

  public List<ReservaDTO> findAll() {
    List<Reserva> reservas = reservaRepository.findAll();
    return convertToDTOList(reservas);
  }

  public ReservaDTO findById(UUID id) {
    Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    return convertToDTO(reserva);
  }

  public ReservaDTO update(UUID id, ReservaDTO reservaDTO) {
    Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

    reserva.setUsuario(reservaDTO.getUsuario());
    reserva.setSala(reservaDTO.getSala());
    reserva.setHorarioInicio(reservaDTO.getHorarioInicio());
    reserva.setHorarioFim(reservaDTO.getHorarioFim());
    reserva.setDuracao(reservaDTO.getDuracao());
    reserva.setQtdParticipantes(reservaDTO.getQtdParticipantes());

    reserva = reservaRepository.save(reserva);
    return convertToDTO(reserva);
  }

  public void delete(UUID id) {
    if (!reservaRepository.existsById(id)) {
      throw new RuntimeException("Reserva não encontrada");
    }
    reservaRepository.deleteById(id);
  }

  private ReservaDTO convertToDTO(Reserva reserva) {
    ReservaDTO reservaDTO = new ReservaDTO();
    reservaDTO.setId(reserva.getId());
    reservaDTO.setUsuario(reserva.getUsuario());
    reservaDTO.setSala(reserva.getSala());
    reservaDTO.setHorarioInicio(reserva.getHorarioInicio());
    reservaDTO.setHorarioFim(reserva.getHorarioFim());
    reservaDTO.setDuracao(reserva.getDuracao());
    reservaDTO.setQtdParticipantes(reserva.getQtdParticipantes());
    return reservaDTO;
  }

  private List<ReservaDTO> convertToDTOList(List<Reserva> reservas) {
    return reservas.stream()
            .map(this::convertToDTO)
            .toList();
  }
}
