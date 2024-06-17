package uy.edu.ucu.pencaucu.service;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;

public interface ITorneoUsuarioService {

	TorneoUsuarioDTO getByTorneoAndUsuario(TorneoUsuarioDTO torneoUsuarioDTO);
	
	List<TorneoUsuarioDTO> getAllByTorneo(Integer id_torneo);
}
