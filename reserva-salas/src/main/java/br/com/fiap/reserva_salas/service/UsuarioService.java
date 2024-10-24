package br.com.fiap.reserva_salas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.fiap.reserva_salas.dto.UsuarioDTO;
import br.com.fiap.reserva_salas.entity.Usuario;
import br.com.fiap.reserva_salas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public Page<UsuarioDTO> findAll(Pageable pageable) {
		Page<Usuario> usuarios = repository.findAll(pageable);
		return usuarios.map(this::toDTO);
	}
	
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.id(), usuarioDTO.nome(), usuarioDTO.cpf());
		repository.save(usuario);
		return toDTO(usuario);
	}
	
	public UsuarioDTO toDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(),usuario.getNome(),usuario.getCpf()); 
		return usuarioDTO;
	}
	
}
