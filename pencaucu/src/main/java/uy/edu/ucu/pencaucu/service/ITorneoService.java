package uy.edu.ucu.pencaucu.service;

import java.util.List;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;

public interface ITorneoService {

	TorneoDTO createTorneo(TorneoDTO torneoDTO);
	
	TorneoDTO updateTorneo(TorneoDTO torneoDTO);
	
	void deleteTorneo(TorneoDTO torneoDTO);
	
	TorneoDTO getTorneo(Integer id_torneo);
	
	List<TorneoDTO> getAllTorneo(TorneoDTO torneoDTO);
	
	
	
}
