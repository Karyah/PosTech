package br.com.fiap.reserva_salas.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.fiap.reserva_salas.controller.exception.ControllerNotFoundException;
import br.com.fiap.reserva_salas.dto.SupervisorDTO;
import br.com.fiap.reserva_salas.entity.Supervisor;
import br.com.fiap.reserva_salas.repository.SupervisorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SupervisorService {

	@Autowired
	private SupervisorRepository repository;

	public Page<SupervisorDTO> findAll(Pageable pageable) {
		Page<Supervisor> supervisores = repository.findAll(pageable);
		return supervisores.map(this::toDTO);
	}

	public SupervisorDTO save(SupervisorDTO supervisorDTO) {
		Supervisor supervisor = toSupervisor(supervisorDTO);
		repository.save(supervisor);
		return toDTO(supervisor);
	}

	public SupervisorDTO update(UUID id, SupervisorDTO supervisorDTO) {
		try {
			Supervisor buscaSupervisor = repository.getReferenceById(id);
			buscaSupervisor.setNome(supervisorDTO.nome());
			buscaSupervisor.setCpf(supervisorDTO.cpf());
			buscaSupervisor.setEmail(supervisorDTO.email());
			buscaSupervisor.setTelefone(supervisorDTO.telefone());
			buscaSupervisor.setPeriodoTrabalho(supervisorDTO.periodoTrabalho());
			buscaSupervisor.setSecaoDeTrabalho(supervisorDTO.secaoDeTrabalho());
			buscaSupervisor = repository.save(buscaSupervisor);
			return toDTO(buscaSupervisor);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Supervisor não encontrado");
		}

	}

	public void delete(UUID id) {
		repository.deleteById(id);
	}
	
	public SupervisorDTO toDTO(Supervisor supervisor) {
		SupervisorDTO supervisorDTO = new SupervisorDTO(supervisor.getId(),supervisor.getNome(),supervisor.getCpf(), supervisor.getEmail(), supervisor.getTelefone(), supervisor.getPeriodoTrabalho(), supervisor.getSecaoDeTrabalho()); 
		return supervisorDTO;
	}
	
	public Supervisor toSupervisor(SupervisorDTO supervisorDTO) {
		Supervisor supervisor = new Supervisor(supervisorDTO.id(), supervisorDTO.nome(), supervisorDTO.cpf(), supervisorDTO.email(), supervisorDTO.telefone(), supervisorDTO.periodoTrabalho(), supervisorDTO.secaoDeTrabalho());
		return supervisor;
	}
	
}
