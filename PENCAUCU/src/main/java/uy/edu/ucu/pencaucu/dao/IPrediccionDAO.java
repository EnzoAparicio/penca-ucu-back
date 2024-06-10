package uy.edu.ucu.pencaucu.dao;	

import java.util.List;

import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;	

public interface IPrediccionDAO {	

        PrediccionDTO createPrediccion (PrediccionDTO prediccionDTO);

        PrediccionDTO getPrediccionById (Integer id_prediccion);	

        List<PrediccionDTO> getAllPrediccion();	
        
        List<PrediccionDTO> getAllPrediccionByFilter(PrediccionDTO prediccionDTO);	

        PrediccionDTO updatePrediccion (PrediccionDTO prediccionDTO);	

        void deletePrediccion (PrediccionDTO prediccionDTO);	
        
        List<PrediccionDTO> getEstadisticaPartido(Integer id_partido);
}

