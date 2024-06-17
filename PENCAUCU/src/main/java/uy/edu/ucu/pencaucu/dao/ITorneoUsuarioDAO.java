package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;

public interface ITorneoUsuarioDAO {
	TorneoUsuarioDTO getByTorneoAndUsuario(TorneoDTO torneoDTO, UsuarioDTO usuarioDTO );
	
	TorneoUsuarioDTO updateTorneoUsuario(TorneoUsuarioDTO torneoUsuarioDTO);
	
	List<TorneoUsuarioDTO> getAllByTorneo(Integer id_torneo);
}
