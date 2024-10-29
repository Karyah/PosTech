package br.com.fiap.reserva_salas.service;

import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.entity.Reserva;
import br.com.fiap.reserva_salas.entity.Sala;
import br.com.fiap.reserva_salas.entity.Usuario;
import br.com.fiap.reserva_salas.repository.ReservaRepository;
import br.com.fiap.reserva_salas.repository.SalaRepository;
import br.com.fiap.reserva_salas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaService {

  private final ReservaRepository reservaRepository;
  private final UsuarioRepository usuarioRepository;
  private final SalaRepository salaRepository;
  private final UsuarioService usuarioService;
  private final SalaService salaService;

  @Autowired
  public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, SalaRepository salaRepository, UsuarioService usuarioService, SalaService salaService) {
    this.reservaRepository = reservaRepository;
    this.usuarioRepository = usuarioRepository;
    this.salaRepository = salaRepository;
    this.usuarioService = usuarioService;
    this.salaService = salaService;
  }

  public ReservaDTO create(ReservaDTO reservaDTO) {
    if (reservaDTO.getUsuario() == null || reservaDTO.getSala() == null) {
      throw new IllegalArgumentException("Usuário e Sala não podem ser nulos");
    }

    Optional<Usuario> usuarioOptional = usuarioRepository.findById(reservaDTO.getUsuario().id());
    Optional<Sala> salaOptional = salaRepository.findById(reservaDTO.getSala().id());

    if (usuarioOptional.isPresent() && salaOptional.isPresent()) {
      Reserva reserva = new Reserva();
      reserva.setUsuario(usuarioOptional.get());
      reserva.setSala(salaOptional.get());
      reserva.setHorarioInicio(reservaDTO.getHorarioInicio());
      reserva.setHorarioFim(reservaDTO.getHorarioFim());
      reserva.setDuracao(reservaDTO.getDuracao());
      reserva.setQtdParticipantes(reservaDTO.getQtdParticipantes());
      reserva.setSala(salaOptional.get());
      reserva.setUsuario(usuarioOptional.get());

      reserva = reservaRepository.save(reserva);
      return convertToDTO(reserva);
    } else {
      throw new RuntimeException("Usuário ou Sala não encontrados");
    }
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

    Usuario usuario = usuarioRepository.findById(reservaDTO.getUsuario().id())
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

    Sala sala = salaRepository.findById(reservaDTO.getSala().id())
            .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

    reserva.setUsuario(usuarioRepository.save(usuario));
    reserva.setSala(salaRepository.save(sala));
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
    reservaDTO.setUsuario(usuarioService.toDTO(reserva.getUsuario()));
    reservaDTO.setSala(salaService.toSalaDTO(reserva.getSala()));
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
