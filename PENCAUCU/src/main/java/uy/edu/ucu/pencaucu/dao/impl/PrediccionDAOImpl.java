
package uy.edu.ucu.pencaucu.dao.impl;	

import java.util.ArrayList;	
import java.util.Optional;	
import java.util.stream.Collectors;	

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.data.domain.Example;	
import org.springframework.stereotype.Repository;	

import uy.edu.ucu.pencaucu.dao.IPrediccionDAO;	
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;	
import uy.edu.ucu.pencaucu.model.Prediccion;	
import uy.edu.ucu.pencaucu.repo.IPrediccionRepo;	
import uy.edu.ucu.pencaucu.util.DozerUtil;	
import uy.edu.ucu.pencaucu.util.HasherUtil;	

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
        Optional<Prediccion> prediccionBD = iPrediccionRepo.findById(id_prediccion);	
        if (prediccionBD.isPresent()) {	
        	return DozerUtil.GetINSTANCE().getMapper().map(prediccionBD.get(), PrediccionDTO.class);	
        }else {	
        	return null;		
        }     	
    }	

    @Override	
    public ArrayList<PrediccionDTO> getAllPrediccion() {	
    	return (ArrayList<PrediccionDTO>) iPrediccionRepo.findAll().stream()	
    			.map(prediccion -> DozerUtil.GetINSTANCE().getMapper().map(prediccion, PrediccionDTO.class))	
    			.collect(Collectors.toList());	
    }	

    @Override	
    public PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO) {	

    	try {	

			Prediccion prediccionActualizada = DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class);	

			return DozerUtil.GetINSTANCE().getMapper().map(iPrediccionRepo.save(prediccionActualizada), PrediccionDTO.class);	

    	} catch (Error e) {	

    		return null;	

		}	
    }	

    @Override	
    public void deletePrediccion(Integer id_prediccion) {	

    	iPrediccionRepo.deleteById(id_prediccion);	
    }	

}
