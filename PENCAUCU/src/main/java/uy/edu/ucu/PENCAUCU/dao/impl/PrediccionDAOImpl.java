package uy.edu.ucu.pencaucu.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dto.PrediccionDTO;
import uy.edu.ucu.pencaucu.util.DozerUtil;
import uy.edu.ucu.pencaucu.repo.IPrediccionRepo;
import uy.edu.ucu.pencaucu.dao.IPrediccionDAO;
import uy.edu.ucu.pencaucu.model.Prediccion;

@Repository
public class PrediccionDAOImpl implements IPrediccionDAO{
   
    @Autowired
    private IPrediccionRepo iPrediccionRepo;

    @Override
    public PrediccionDTO createPrediccion(PrediccionDTO prediccionDTO){
        Prediccion prediccion = DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class);
        
        Prediccion savedPrediccion = iPrediccionRepo.save(prediccion);

        return DozerUtil.GetINSTANCE().getMapper().map(savedPrediccion, PrediccionDTO.class);



    }

    @Override
    public PrediccionDTO getPrediccionById(Integer id_prediccion) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPrediccionById'");
    }

    @Override
    public ArrayList<PrediccionDTO> getAllPrediccion() {
  
        throw new UnsupportedOperationException("Unimplemented method 'getAllPrediccion'");
    }

    @Override
    public PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO) {
       
        throw new UnsupportedOperationException("Unimplemented method 'updatePrediccion'");
    }

    @Override
    public PrediccionDTO deletePrediccion(Integer id_prediccion) {
      
        throw new UnsupportedOperationException("Unimplemented method 'deletePrediccion'");
    }
    
}
