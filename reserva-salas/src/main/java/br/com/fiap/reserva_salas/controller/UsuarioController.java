package br.com.fiap.reserva_salas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.reserva_salas.dto.UsuarioDTO;
import br.com.fiap.reserva_salas.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> findAll(@PageableDefault(size=5,page=0, sort="cpf") Pageable pageable){
		Page<UsuarioDTO> usuariosDTO = service.findAll(pageable);
		return ResponseEntity.ok(usuariosDTO);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO usuarioSalvo = service.save(usuarioDTO);
		return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
	}
}
