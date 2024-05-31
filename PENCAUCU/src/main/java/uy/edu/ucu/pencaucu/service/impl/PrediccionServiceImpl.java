package uy.edu.ucu.pencaucu.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IPrediccionDAO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;
import uy.edu.ucu.pencaucu.service.IPrediccionService;


@Service
public class PrediccionServiceImpl implements IPrediccionService {

	@Autowired
	IPrediccionDAO iPrediccionDAO;
	
	@Override
	public PrediccionDTO createPrediccion(PrediccionDTO prediccionDTO) {
		return iPrediccionDAO.createPrediccion(prediccionDTO);
	}

	@Override
	public PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO) {
		return iPrediccionDAO.updatePrediccion(prediccionDTO);
	}

	@Override
	public void deletePrediccion(Integer id_prediccion) {
		iPrediccionDAO.deletePrediccion(id_prediccion);
	}

	@Override
	public PrediccionDTO getPrediccion(Integer id_prediccion) {
		return iPrediccionDAO.getPrediccionById(id_prediccion);
	}

	@Override
	public ArrayList<PrediccionDTO> getAllPrediccion(PrediccionDTO prediccionDTO) {
		if (prediccionDTO == null) {
			return iPrediccionDAO.getAllPrediccion();
		} else {
			return null;
		}
	}

	

}