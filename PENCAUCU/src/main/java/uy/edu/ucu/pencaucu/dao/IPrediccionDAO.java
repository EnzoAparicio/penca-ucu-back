package uy.edu.ucu.pencaucu.dao;	

import java.util.ArrayList;	

import uy.edu.ucu.pencaucu.dto.PrediccionDTO;	

public interface IPrediccionDAO {	

        PrediccionDTO createPrediccion (PrediccionDTO prediccionDTO);

        PrediccionDTO getPrediccionById (Integer id_prediccion);	

        public ArrayList<PrediccionDTO> getAllPrediccion();	

        PrediccionDTO updatePrediccion (PrediccionDTO prediccionDTO);	

        void deletePrediccion (PrediccionDTO prediccionDTO);	

}

