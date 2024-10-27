package br.com.fiap.reserva_salas.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.reserva_salas.dto.SupervisorDTO;
import br.com.fiap.reserva_salas.service.SupervisorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {
	
	@Autowired
	private SupervisorService service;
	
	@GetMapping
	public ResponseEntity<Page<SupervisorDTO>> findAll(@PageableDefault(size=5,page=0, sort="cpf") Pageable pageable){
		Page<SupervisorDTO> supervisoresDTO = service.findAll(pageable);
		return ResponseEntity.ok(supervisoresDTO);
	}
	
	@PostMapping
	public ResponseEntity<SupervisorDTO> save(@Valid @RequestBody SupervisorDTO supervisorDTO) {
		SupervisorDTO supervisorSalvo = service.save(supervisorDTO);
		return new ResponseEntity<>(supervisorSalvo, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SupervisorDTO> update(@PathVariable UUID id, @Valid @RequestBody SupervisorDTO supervisorDTO){
		SupervisorDTO buscaSupervisorDTO = service.update(id, supervisorDTO);
		return ResponseEntity.ok(buscaSupervisorDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
