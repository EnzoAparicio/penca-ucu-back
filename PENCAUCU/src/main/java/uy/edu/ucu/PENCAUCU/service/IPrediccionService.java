package uy.edu.ucu.pencaucu.service;

import java.util.ArrayList;

import uy.edu.ucu.pencaucu.dto.PrediccionDTO;

public interface IPrediccionService {

    PrediccionDTO createPrediccion(PrediccionDTO prediccionDTO);

    PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO);

    void deletePrediccion(Integer id_prediccion);

    PrediccionDTO getPrediccion(Integer id_prediccion);

    ArrayList<PrediccionDTO> getAllPrediccion(PrediccionDTO prediccionDTO);
}
