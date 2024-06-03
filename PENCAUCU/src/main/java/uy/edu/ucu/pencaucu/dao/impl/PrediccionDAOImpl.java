
package uy.edu.ucu.pencaucu.dao.impl;	

import java.util.List;
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

        if (savedPrediccion.getId_prediccion() == null) {
        	return new PrediccionDTO();
        } else {
            // Mapear la entidad guardada de vuelta a DTO
            return DozerUtil.GetINSTANCE().getMapper().map(savedPrediccion, PrediccionDTO.class);
        }	
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
        	return new PrediccionDTO();		
        }     	
    }

    @Override	
    public List<PrediccionDTO> getAllPrediccion() {	
        // Buscar todas las predicciones en la base de datos utilizando Dozer para mapear las entidades a DTOs y devolverlas
    	return iPrediccionRepo.findAll().stream()	
    			.map(prediccion -> DozerUtil.GetINSTANCE().getMapper().map(prediccion, PrediccionDTO.class))	
    			.collect(Collectors.toList());
    }	

    @Override	
    public List<PrediccionDTO> getAllPrediccionByFilter(PrediccionDTO prediccionDTO) {	
    	Example<Prediccion> prediccionExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class));
    	
    	return iPrediccionRepo.findAll(prediccionExample).stream()
    			.map(prediccion -> DozerUtil.GetINSTANCE().getMapper().map(prediccion, PrediccionDTO.class))
				.collect(Collectors.toList());
    }

    @Override	
    public PrediccionDTO updatePrediccion(PrediccionDTO prediccionDTO) {	
		Prediccion prediccion = DozerUtil.GetINSTANCE().getMapper().map(prediccionDTO, Prediccion.class);	
		prediccion = iPrediccionRepo.save(prediccion);
		if (prediccion.getId_prediccion() == null) {
			return new PrediccionDTO();
		} else {
			return DozerUtil.GetINSTANCE().getMapper().map(iPrediccionRepo.save(prediccion), PrediccionDTO.class);
		}
    }	

    @Override	
    public void deletePrediccion(PrediccionDTO prediccionDTO) {	
        // Eliminar la prediccion de la base de datos según el id indicado
    	iPrediccionRepo.deleteById(prediccionDTO.getId_prediccion());
    }	

}
