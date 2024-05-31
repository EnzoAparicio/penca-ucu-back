package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.ITorneoDAO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.repo.ITorneoRepo;

@Repository
public class TorneoDAOImpl implements ITorneoDAO {

	@Autowired
	ITorneoRepo iTorneoRepo;
	
	@Override
	public TorneoDTO createTorneo(TorneoDTO torneoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TorneoDTO updateTorneo(TorneoDTO TorneoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTorneo(TorneoDTO torneoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TorneoDTO getTorneo(Integer id_torneo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TorneoDTO> getAllTorneo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TorneoDTO> getAllTorneoByFilter(TorneoDTO torneoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
