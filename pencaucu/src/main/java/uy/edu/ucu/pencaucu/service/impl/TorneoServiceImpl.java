package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.pencaucu.dao.ITorneoDAO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.service.ITorneoService;

@Service
public class TorneoServiceImpl implements ITorneoService {

	@Autowired
	ITorneoDAO iTorneoDAO;

	@Override
	public TorneoDTO createTorneo(TorneoDTO torneoDTO) {
		try {
			if (torneoDTO.getNombre() == null || torneoDTO.getAnio() == null) {
				throw new Exception("Campos faltantes para creacion.");
			}
			return iTorneoDAO.createTorneo(torneoDTO);
		} catch (Exception camposFaltantes) {
			return null;
		}
	}

	@Override
	public TorneoDTO updateTorneo(TorneoDTO torneoDTO) {
		try {
			if (torneoDTO.getNombre() == null || torneoDTO.getAnio() == null || torneoDTO.getIdTorneo() == null) {
				throw new Exception("Campos faltantes para actualizacion.");
			}
			return iTorneoDAO.updateTorneo(torneoDTO);
		} catch (Exception camposFaltantes) {
			return null;
		}
	}

	@Override
	public void deleteTorneo(TorneoDTO torneoDTO) {
		iTorneoDAO.deleteTorneo(torneoDTO);
	}

	@Override
	public TorneoDTO getTorneo(Integer id_torneo) {
		return iTorneoDAO.getTorneo(id_torneo);
	}

	@Override
	public List<TorneoDTO> getAllTorneo(TorneoDTO torneoDTO) {
		if (torneoDTO == null) {
			return iTorneoDAO.getAllTorneo();
		} else {
			return iTorneoDAO.getAllTorneoByFilter(torneoDTO);
		}
	}

}
