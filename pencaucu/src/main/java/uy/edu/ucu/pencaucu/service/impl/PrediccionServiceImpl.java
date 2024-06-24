package uy.edu.ucu.pencaucu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IPrediccionDAO;
import uy.edu.ucu.pencaucu.dao.ITorneoUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.service.IPrediccionService;

@Service
public class PrediccionServiceImpl implements IPrediccionService {

	private static final int EXACT_RESULT_POINTS = 4;
	private static final int CORRECT_RESULT_POINTS = 2;

	@Autowired
	IPrediccionDAO iPrediccionDAO;

	@Autowired
	ITorneoUsuarioDAO iTorneoUsuarioDAO;

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
			Integer[] teamCounter = { 0, 0, 0 };
			for (PrediccionDTO prediccionDTO : prediccionDTOList) {
				if (prediccionDTO.getPrediccionEquipo1() == prediccionDTO.getPrediccionEquipo2()) {
					teamCounter[0] += 1;
				} else if (prediccionDTO.getPrediccionEquipo1() > prediccionDTO.getPrediccionEquipo2()) {
					teamCounter[1] += 1;
				} else {
					teamCounter[2] += 1;
				}
			}

			// Transform the entries of each prediction to a percentage
			Integer totalEntries = teamCounter[0] + teamCounter[1] + teamCounter[2];
			if (totalEntries == 0) {
				for (int i = 0; i < 3; i++)
					teamCounter[i] = 0;
			} else {
				// Draw is not calculated but derived, to avoid totals resulting in 99% or 98%
				// in case Java rounding lost that %.
				teamCounter[0] = 100;
				for (int i = 1; i < 3; i++) {
					teamCounter[i] = (teamCounter[i] * 100) / totalEntries;
					teamCounter[0] -= teamCounter[i];
				}
			}

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

	@Override
	public void checkResultado(PartidoDTO partidoDTO) {
		Integer[] result = { 0, 0 };
		for (EquipoPartido equipoPartido : partidoDTO.getEquipos()) {
			// TipoEquipo equals 1 or 2, so we deduct 1 to equal array position [0-1]
			result[equipoPartido.getTipoEquipo() - 1] = equipoPartido.getResultado();
		}

		List<PrediccionDTO> prediccionDTOList = iPrediccionDAO.getAllPrediccionByPartido(partidoDTO);
		for (PrediccionDTO prediccionDTO : prediccionDTOList) {
			// Make sure the points are not already assigned and, if so, update them.
			Integer startingPointsSecurity = prediccionDTO.getPuntos();
			startingPointsSecurity = startingPointsSecurity == null ? 0 : startingPointsSecurity;

			// Assign the corresponding points.
			Integer[] userResult = { prediccionDTO.getPrediccionEquipo1(), prediccionDTO.getPrediccionEquipo2() };
			Integer pointsToAssign = 0;
			if (userResult[0] == result[0] && userResult[1] == result[1]) {
				pointsToAssign += EXACT_RESULT_POINTS;
			} else if (userResult[0] > userResult[1] && result[0] > result[1]
					|| userResult[0] < userResult[1] && result[0] < result[1]
					|| userResult[0] == userResult[1] && result[0] == result[1]) {
				pointsToAssign += CORRECT_RESULT_POINTS;
			}

			// Update prediccion with new points.
			prediccionDTO.setPuntos(pointsToAssign);
			iPrediccionDAO.updatePrediccion(prediccionDTO);

			// Get TorneoUsuario entity to get current points.
			TorneoDTO torneoDTO = new TorneoDTO();
			torneoDTO.setIdTorneo(prediccionDTO.getPartido().getIdTorneo());
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdUsuario(prediccionDTO.getIdUsuario());
			TorneoUsuarioDTO torneoUsuarioDTO = iTorneoUsuarioDAO.getByTorneoAndUsuario(torneoDTO, usuarioDTO);

			// Update entity with new points.
			Integer currentPoints = torneoUsuarioDTO.getPuntos() == null ? 0 : torneoUsuarioDTO.getPuntos();
			torneoUsuarioDTO.setPuntos((pointsToAssign - startingPointsSecurity) + currentPoints);
			iTorneoUsuarioDAO.updateTorneoUsuario(torneoUsuarioDTO);
		}
	}
}