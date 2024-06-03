package uy.edu.ucu.pencaucu.controller;	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.web.bind.annotation.DeleteMapping;	
import org.springframework.web.bind.annotation.GetMapping;	
import org.springframework.web.bind.annotation.PathVariable;	
import org.springframework.web.bind.annotation.PostMapping;	
import org.springframework.web.bind.annotation.PutMapping;	
import org.springframework.web.bind.annotation.RequestBody;	
import org.springframework.web.bind.annotation.RestController;	

import uy.edu.ucu.pencaucu.dto.PrediccionDTO;	
import uy.edu.ucu.pencaucu.service.IPrediccionService;	

@RestController	
public class PrediccionController {	

    @Autowired	
    private IPrediccionService iPrediccionService;	

    @GetMapping("/prediccion/getAll") // Envia un json con todas las predicciones
    public List<PrediccionDTO> getAllPrediccion(@RequestBody(required = false) PrediccionDTO prediccionDTO) {	
		return iPrediccionService.getAllPrediccion(prediccionDTO);	
    }	

    @GetMapping("/prediccion/{id_prediccion}")	// Envia un json con la prediccion que tiene el id indicado
    public PrediccionDTO getPrediccion(@PathVariable Integer id_prediccion) {	
		return iPrediccionService.getPrediccion(id_prediccion);	
	}	

    @PostMapping("/prediccion/create")	 // Crea una prediccion y la devuelve en un json
	public PrediccionDTO createPrediccion(@RequestBody PrediccionDTO prediccionDTO) {	
		return iPrediccionService.createPrediccion(prediccionDTO);	
	}	

    @DeleteMapping("/prediccion/delete") // Elimina la prediccion con el id indicado
	public void deletePrediccion(@RequestBody PrediccionDTO prediccionDTO) {	
        iPrediccionService.deletePrediccion(prediccionDTO);	
    }	

    @PutMapping("/prediccion/update") // Actualiza la prediccion con los datos del json y la devuelve	
	public PrediccionDTO updatePrediccion(@RequestBody PrediccionDTO prediccionDTO) {	
		return iPrediccionService.updatePrediccion(prediccionDTO);	
	}	

}
