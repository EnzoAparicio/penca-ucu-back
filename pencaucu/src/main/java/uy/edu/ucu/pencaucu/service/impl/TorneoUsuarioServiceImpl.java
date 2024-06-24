package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.ITorneoUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.service.ITorneoUsuarioService;

@Service
public class TorneoUsuarioServiceImpl implements ITorneoUsuarioService {

	@Autowired
	ITorneoUsuarioDAO iTorneoUsuarioDAO;

	@Override
	public TorneoUsuarioDTO getByTorneoAndUsuario(TorneoUsuarioDTO torneoUsuarioDTO) {
		TorneoDTO torneoDTO = new TorneoDTO();
		torneoDTO.setIdTorneo(torneoUsuarioDTO.getTorneo().getIdTorneo());
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUsuario(torneoUsuarioDTO.getUsuario().getIdUsuario());
		return iTorneoUsuarioDAO.getByTorneoAndUsuario(torneoDTO, usuarioDTO);
	}

	@Override
	public List<TorneoUsuarioDTO> getAllByIdTorneo(Integer id_torneo) {
		return iTorneoUsuarioDAO.getAllByIdTorneo(id_torneo);
	}

	@Override
	public TorneoUsuarioDTO createTorneoUsuario(TorneoUsuarioDTO torneoUsuarioDTO) {
		return iTorneoUsuarioDAO.createTorneoUsuario(torneoUsuarioDTO);
	}

}
