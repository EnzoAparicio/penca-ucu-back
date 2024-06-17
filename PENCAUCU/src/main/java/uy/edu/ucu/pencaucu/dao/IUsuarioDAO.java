package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.UsuarioDTO;

public interface IUsuarioDAO {
	
	/**
	 * Actualiza un Usuario en la Base de Datos.
	 * 
	 * @param usuarioDTO
	 * @return UsuarioDTO actualizado.
	 */
	UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO);
	
	
	/**
	 * Elimina un Usuario en la Base de Datos segun su Id.
	 * 
	 * Si no se encuentra el Usuario, es ignorado sin errores.
	 * 
	 * @param usuarioDTO
	 */
	void deleteUsuario(UsuarioDTO usuarioDTO);
	
	/**
	 * Devuelve un Usuario segun su ID en la Base de Datos.
	 * 
	 * @param id_usuario
	 * @return UsuarioDTO con id_usuario, null si no existe.
	 */
	UsuarioDTO getUsuario(Integer id_usuario);
	
	/**
	 * Devuelve todas las entradas de Usuario en la Base de Datos.
	 * 
	 * @return List<UsuarioDTO> poblada o List vacía si no hay ningún Usuario.
	 */
	List<UsuarioDTO> getAllUsuario();
	
	
	/**
	 * Devuelve todas las entradas de Usuario en la Base de datos
	 * que coincidan en atributos.
	 * 
	 * @param UsuarioDTO poblado solamente con los atributos por los que se quiera filtrar.
	 * @return List<UsuarioDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	List<UsuarioDTO> getAllUsuarioByFilter(UsuarioDTO usuarioDTO);
}
