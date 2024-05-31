
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
        // Usar Dozer para mapear DTO a entidad
        Prediccion prediccion = DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class);	

        // Guardar el objeto prediccion en la base de datos 
        Prediccion savedPrediccion = iPrediccionRepo.save(prediccion);	

        // Mapear la entidad guardada de vuelta a DTO
        return DozerUtil.GetINSTANCE().getMapper().map(savedPrediccion, PrediccionDTO.class);	
    }	

    @Override	
    public PrediccionDTO getPrediccionById(Integer id_prediccion) {	
        // Buscar la prediccion en la base de datos por id
        Optional<Prediccion> prediccionBD = iPrediccionRepo.findById(id_prediccion);
        // Si la prediccion existe, usar Dozer para mapear la entidad a DTO y devolverlo	
        if (prediccionBD.isPresent()) {	
        	return DozerUtil.GetINSTANCE().getMapper().map(prediccionBD.get(), PrediccionDTO.class);	
        // Si la prediccion no existe, devolver null
        }else {	
        	return null;		
        }     	
    }	

    @Override	
    public ArrayList<PrediccionDTO> getAllPrediccion() {	
        // Buscar todas las predicciones en la base de datos utilizando Dozer para mapear las entidades a DTOs y devolverlas
    	return (ArrayList<PrediccionDTO>) iPrediccionRepo.findAll().stream()	
    			.map(prediccion -> DozerUtil.GetINSTANCE().getMapper().map(prediccion, PrediccionDTO.class))	
    			.collect(Collectors.toList());	
    }	

    @Override	
    public PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO) {	
        // Actualizar la prediccion en la base de datos
    	try {	
            // Usar Dozer para mapear DTO a entidad
			Prediccion prediccionActualizada = DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class);	
            // Guardar el objeto prediccion en la base de datos
			return DozerUtil.GetINSTANCE().getMapper().map(iPrediccionRepo.save(prediccionActualizada), PrediccionDTO.class);	
        // Si la prediccion no existe, devolver null
    	} catch (Error e) {	
    		return null;	
		}	
    }	

    @Override	
    public void deletePrediccion(Integer id_prediccion) {	
        // Eliminar la prediccion de la base de datos según el id indicado
    	iPrediccionRepo.deleteById(id_prediccion);	
    }	

}
