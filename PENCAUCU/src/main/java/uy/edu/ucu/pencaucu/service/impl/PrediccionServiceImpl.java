package uy.edu.ucu.pencaucu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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
	public HashMap<String, Integer> getEstadisticaPartido(Integer id_partido) {
		if (id_partido != null) {
			List<PrediccionDTO> prediccionDTOList = iPrediccionDAO.getEstadisticaPartido(id_partido);
			
			// Assigns a counter with [0] = draw, [1] winner1, [2] winner2
	    	Integer[] teamCounter = {0, 0, 0};
	    	for (PrediccionDTO prediccionDTO : prediccionDTOList) {
	    		if (prediccionDTO.getPrediccion_equipo1() == prediccionDTO.getPrediccion_equipo2()) {
	    			teamCounter[0] += 1;
	    		} else if (prediccionDTO.getPrediccion_equipo1() > prediccionDTO.getPrediccion_equipo2()) {
	    			teamCounter[1] += 1;
	    		} else {
	    			teamCounter[2] += 1;
	    		}
			}
	    	
	    	System.out.println(String.format("\nCounter state: %2d, %2d, %2d", teamCounter[0], teamCounter[1], teamCounter[2]));
	    	
	    	// Transform the entries of each prediction to a percentage
	    	Integer totalEntries = teamCounter[0] + teamCounter[1] + teamCounter[2];
	    	if ( totalEntries == 0 ) {
	    		for (int i = 0; i < 3; i++) teamCounter[i] = 0;
	    	} else {
	    		// Draw is not calculated but derived, to avoid totals resulting in 99% or 98% in case Java rounding lost that %.
	    		teamCounter[0] = 100;
	    		for (int i = 1; i < 3; i++) {
	        		teamCounter[i] = (teamCounter[i] * 100) /totalEntries;
	        		teamCounter[0] -= teamCounter[i];
	    		}
	    	}
	    	
	    	System.out.println(String.format("\nPercentages state: %2d, %2d, %2d", teamCounter[0], teamCounter[1], teamCounter[2]));
	    	
	    	// Map the percentages to the keys.
	    	HashMap<String, Integer> stats = new HashMap<String, Integer>();
	    	stats.put("equipo1", teamCounter[1]);
	    	stats.put("equipo2", teamCounter[2]);
	    	stats.put("empate", teamCounter[0]);
	    	
	    	return stats;
		} else {
			return new HashMap<String, Integer>();
		}
	}
}