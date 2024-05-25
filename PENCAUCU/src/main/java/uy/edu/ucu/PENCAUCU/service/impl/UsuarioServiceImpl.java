package uy.edu.ucu.PENCAUCU.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.PENCAUCU.dao.IUsuarioDAO;
import uy.edu.ucu.PENCAUCU.dto.UsuarioDTO;
import uy.edu.ucu.PENCAUCU.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	@Override
	public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
		return iUsuarioDAO.createUsuario(usuarioDTO);
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		return iUsuarioDAO.updateUsuario(usuarioDTO);
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
		return iUsuarioDAO.getAllUsuario(usuarioDTO);
	}

}
