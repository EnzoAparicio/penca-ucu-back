package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		try {
			if(usuarioDTO.getEmail() == null || usuarioDTO.getContrasenia() == null 
					|| usuarioDTO.getNombre() == null || usuarioDTO.getCarrera() == null
					|| usuarioDTO.getApellido() == null || usuarioDTO.getIdUsuario() == null) {
				throw new Exception("Campos faltantes para la actualización.");
			}
			return iUsuarioDAO.updateUsuario(usuarioDTO); 
		} catch (Exception camposFaltantes) {
			return null;
		}
	}

	@Override
	public void deleteUsuario(UsuarioDTO usuarioDTO) {
		iUsuarioDAO.deleteUsuario(usuarioDTO);
	}

	@Override
	public UsuarioDTO getUsuario(Integer id_usuario) {
		return iUsuarioDAO.getUsuario(id_usuario);
	}

	@Override
	public List<UsuarioDTO> getAllUsuario(UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return iUsuarioDAO.getAllUsuario();
		} else {
			return iUsuarioDAO.getAllUsuarioByFilter(usuarioDTO);
		}
	}

}
