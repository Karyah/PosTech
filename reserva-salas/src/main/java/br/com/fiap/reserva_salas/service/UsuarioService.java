package br.com.fiap.reserva_salas.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.reserva_salas.controller.exception.ControllerNotFoundException;
import br.com.fiap.reserva_salas.dto.UsuarioDTO;
import br.com.fiap.reserva_salas.entity.Usuario;
import br.com.fiap.reserva_salas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public Page<UsuarioDTO> findAll(Pageable pageable) {
		Page<Usuario> usuarios = repository.findAll(pageable);
		return usuarios.map(this::toDTO);
	}
	
	public UsuarioDTO findById(UUID id) {
		Usuario usuario = repository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Usuário não encontrado"));
		return toDTO(usuario);
	}
	
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = toUsuario(usuarioDTO);
		repository.save(usuario);
		return toDTO(usuario);
	}
	
	public UsuarioDTO update(UUID id, UsuarioDTO usuarioDTO) {
		try {
			Usuario buscaUsuario = repository.getReferenceById(id);
			buscaUsuario.setNome(usuarioDTO.nome());
			buscaUsuario.setCpf(usuarioDTO.cpf());
			buscaUsuario.setEmail(usuarioDTO.email());
			buscaUsuario.setTelefone(usuarioDTO.telefone());
			buscaUsuario = repository.save(buscaUsuario);
			return toDTO(buscaUsuario);
		}catch(EntityNotFoundException e) {
			throw new ControllerNotFoundException("Usuário não encontrado");
		}
		
	}
	
	public void delete(UUID id) {
		repository.deleteById(id);
	}
	
	public UsuarioDTO toDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(),usuario.getNome(),usuario.getCpf(), usuario.getEmail(), usuario.getTelefone()); 
		return usuarioDTO;
	}
	
	public Usuario toUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.id(), usuarioDTO.nome(), usuarioDTO.cpf(), usuarioDTO.email(), usuarioDTO.telefone());
		return usuario;
	}
	
}
