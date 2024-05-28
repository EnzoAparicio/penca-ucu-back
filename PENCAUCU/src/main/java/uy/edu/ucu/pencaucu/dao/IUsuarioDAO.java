package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.UsuarioDTO;

public interface IUsuarioDAO {

	UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO loginUsuario(String email, String password);
	
	UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO);
	
	void deleteUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO getUsuario(Integer id_usuario);
	
	List<UsuarioDTO> getAllUsuario();
	
	List<UsuarioDTO> getAllUsuarioByFilter(UsuarioDTO usuarioDTO);
}
