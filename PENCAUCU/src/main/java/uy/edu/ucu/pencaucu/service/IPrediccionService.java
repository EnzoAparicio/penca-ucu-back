package uy.edu.ucu.pencaucu.service;	

import java.util.List;

import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;	

public interface IPrediccionService {	

    PrediccionDTO createPrediccion(PrediccionDTO prediccionDTO);	

    PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO);	

    void deletePrediccion(PrediccionDTO prediccionDTO);	

    PrediccionDTO getPrediccion(Integer id_prediccion);	

    List<PrediccionDTO> getAllPrediccion(PrediccionDTO prediccionDTO);
    
    List<PrediccionDTO> getPrediccionByPartido(PartidoDTO partidoDTO);
}