package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.repo.IUsuarioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {

	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	@Override
	public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioDTO getUsuario(Integer idUsuario) {
		return DozerUtil.GetINSTANCE().getMapper().map(iUsuarioRepo.findById(idUsuario), UsuarioDTO.class);
	}

	@Override
	public List<UsuarioDTO> getAllUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
