package uy.edu.ucu.PENCAUCU.service;

import java.util.List;

import uy.edu.ucu.PENCAUCU.dto.UsuarioDTO;

public interface IUsuarioService {

	UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO);
	
	void deleteUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO getUsuario(Integer id_usuario);
	
	List<UsuarioDTO> getAllUsuario(UsuarioDTO usuarioDTO);
}
