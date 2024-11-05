package br.com.fiap.reserva_salas.controller;

import br.com.fiap.reserva_salas.dto.ReservaDTO;
import br.com.fiap.reserva_salas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

	/*Usuários devem ser capazes de criar uma reserva, e deletar e atualizar sua reserva.
	 * Supervisores devem ser capazes de ver todas as reservas, alterar e deletar a reserva de qualquer usuário.*/
	
	private final ReservaService reservaService;

	@Autowired
	public ReservaController(ReservaService reservaService) {
		this.reservaService = reservaService;
	}

	@PostMapping
	public ResponseEntity<ReservaDTO> create(@RequestBody ReservaDTO reservaDTO) {
		ReservaDTO novaReserva = reservaService.create(reservaDTO);
		return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ReservaDTO>> findAll() {
		List<ReservaDTO> reservas = reservaService.findAll();
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReservaDTO> findById(@PathVariable UUID id) {
		ReservaDTO reserva = reservaService.findById(id);
		return new ResponseEntity<>(reserva, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReservaDTO> update(@PathVariable UUID id, @RequestBody ReservaDTO reservaDTO) {
		ReservaDTO reservaAtualizada = reservaService.update(id, reservaDTO);
		return new ResponseEntity<>(reservaAtualizada, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		reservaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
