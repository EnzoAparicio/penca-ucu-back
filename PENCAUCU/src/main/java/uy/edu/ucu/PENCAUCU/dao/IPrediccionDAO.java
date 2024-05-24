package uy.edu.ucu.PENCAUCU.dao;

import java.util.ArrayList;

import uy.edu.ucu.PENCAUCU.dto.PrediccionDTO;

public interface IPrediccionDAO {
    
        public PrediccionDTO findPrediccion (int id_prediccion);

        public ArrayList<PrediccionDTO> findAllPredicciones();

        public void savePrediccion(PrediccionDTO prediccion);

        public void updatePrediccion(PrediccionDTO prediccion);

        public void deletePrediccion(int id_prediccion);
        
}
