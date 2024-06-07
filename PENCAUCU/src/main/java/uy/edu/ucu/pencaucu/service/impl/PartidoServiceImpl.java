package uy.edu.ucu.pencaucu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.pencaucu.dao.IPartidoDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.model.Partido;
import uy.edu.ucu.pencaucu.service.IPartidoService;
import uy.edu.ucu.pencaucu.service.IPrediccionService;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Service
public class PartidoServiceImpl implements IPartidoService {

    @Autowired
    IPartidoDAO iPartidoDAO;
    
    @Autowired
    IPrediccionService iPrediccionService;
    
    private HashMap<String, Integer> calcularEstadistica(PartidoDTO partidoDTO, List<PrediccionDTO> prediccionList) {
    	System.out.println("\n Counting stats:\nPartido:" + partidoDTO.toString() + "\nPredicciones: ");
    	
    	// Assigns a counter with [0] = draw, [1] winner1, [2] winner2
    	Integer[] teamCounter = {0, 0, 0};
    	for (PrediccionDTO prediccionDTO : prediccionList) {
    		Equipo winner = prediccionDTO.getGanador(); 
    		if (winner == null) {
    			teamCounter[0] += 1;
    		} else {
    			EquipoPartido equipoPartido = partidoDTO.getEquipos().get(0); 
    			Boolean matchWinner = equipoPartido.getEquipo().getId_equipo() == winner.getId_equipo();
    			if (matchWinner && equipoPartido.getTipo_equipo() == 1
    					|| !matchWinner && equipoPartido.getTipo_equipo() == 2) {
    				teamCounter[1] += 1;
    			} else {
    				teamCounter[2] += 1;
    			}
    		}
		}
    	
    	System.out.println("\nCounter state: " + teamCounter.toString());
    	
    	// Transform the entries of each prediction to a percentage
    	Integer totalEntries = teamCounter[0] + teamCounter[1] + teamCounter[2];
    	if ( totalEntries == 0 ) {
    		for (int i = 0; i < 3; i++) teamCounter[i] = 0;
    	} else {
    		// Draw is not calculated but derived, to avoid totals resulting in 99% or 98% in case Java rounding lost that %.
    		teamCounter[0] = 100;
    		for (int i = 1; i < 3; i++) {
        		teamCounter[i] = (teamCounter[i]/totalEntries) * 100;
        		teamCounter[0] -= teamCounter[i];
    		}
    	}
    	
    	System.out.println("\nPercentages state: " + teamCounter.toString());
    	
    	// Map the percentages to the keys.
    	HashMap<String, Integer> stats = new HashMap<String, Integer>();
    	stats.put("equipo1", teamCounter[1]);
    	stats.put("equipo2", teamCounter[2]);
    	stats.put("empate", teamCounter[0]);
    	return stats;
    }

    /**
     * Crea un nuevo partido.
     * 
     * @param partidoDTO Datos del partido a crear.
     * @return Partido creado.
     */
    @Override
    public PartidoDTO createPartido(PartidoDTO partidoDTO) {
        return iPartidoDAO.createPartido(partidoDTO);
    }

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO Datos del partido a actualizar.
     * @return Partido actualizado.
     */
    @Override
    public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
        return iPartidoDAO.updatePartido(partidoDTO);
    }

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO Datos del partido a eliminar.
     */
    @Override
    public void deletePartido(PartidoDTO partidoDTO) {
        iPartidoDAO.deletePartido(partidoDTO);
    }

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido Identificador del partido.
     * @return Partido encontrado.
     */
    @Override
    public PartidoDTO getPartido(Integer id_partido) {
        return iPartidoDAO.getPartido(id_partido);
    }

    /**
     * Obtiene todos los partidos.
     * 
     * @param partidoDTO Filtros de búsqueda opcionales.
     * @return Lista de partidos.
     */
    @Override
    public List<PartidoDTO> getAllPartido(PartidoDTO partidoDTO) {
        if (partidoDTO == null) {
            return iPartidoDAO.getAllPartido();
        } else {
            return iPartidoDAO.getAllPartidoByFilter(partidoDTO);
        }
    }

	@Override
	public HashMap<String, Integer> getEstadisticaPartido(Integer id_partido) {
		PartidoDTO partidoDTO = iPartidoDAO.getPartido(id_partido);
		if (partidoDTO.getId_partido() != null) {
			List<PrediccionDTO> prediccionList = iPrediccionService.getPrediccionByPartido(partidoDTO);
			return calcularEstadistica(partidoDTO, prediccionList);
		} else {
			return new HashMap<String, Integer>();
		}
	}
}
