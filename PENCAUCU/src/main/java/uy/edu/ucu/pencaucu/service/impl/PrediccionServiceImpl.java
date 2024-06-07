package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IPrediccionDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
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
	public void deletePrediccion(PrediccionDTO prediccionDTO) {
		iPrediccionDAO.deletePrediccion(prediccionDTO);
	}

	@Override
	public PrediccionDTO getPrediccion(Integer id_prediccion) {
		return iPrediccionDAO.getPrediccionById(id_prediccion);
	}

	@Override
	public List<PrediccionDTO> getAllPrediccion(PrediccionDTO prediccionDTO) {
		if (prediccionDTO == null) {
			return iPrediccionDAO.getAllPrediccion();
		} else {
			return iPrediccionDAO.getAllPrediccionByFilter(prediccionDTO);
		}
	}

	@Override
	public List<PrediccionDTO> getPrediccionByPartido(PartidoDTO partidoDTO) {
		return iPrediccionDAO.getPrediccionByPartido(partidoDTO);
	}
	
	
}