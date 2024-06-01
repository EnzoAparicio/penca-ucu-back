package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.TorneoDTO;

public interface ITorneoDAO {

	TorneoDTO createTorneo(TorneoDTO torneoDTO);
	
	TorneoDTO updateTorneo(TorneoDTO TorneoDTO);
	
	void deleteTorneo(TorneoDTO torneoDTO);
	
	TorneoDTO getTorneo(Integer id_torneo);	
	
	List<TorneoDTO> getAllTorneo();
	
	List<TorneoDTO> getAllTorneoByFilter(TorneoDTO torneoDTO);
}