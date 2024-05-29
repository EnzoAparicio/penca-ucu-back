package uy.edu.ucu.pencaucu.controller;

import java.util.ArrayList;

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

    @GetMapping("/prediccion/getAll")
    public ArrayList<PrediccionDTO> getAllPrediccion(@RequestBody(required = false) PrediccionDTO prediccionDTO) {
		return iPrediccionService.getAllPrediccion(prediccionDTO);
    }

    @GetMapping("/prediccion/{id_prediccion}")
    public PrediccionDTO getPrediccion(@PathVariable Integer id_prediccion) {
		return iPrediccionService.getPrediccion(id_prediccion);
	}
    
    @PostMapping("/prediccion/create")
	public PrediccionDTO createPrediccion(@RequestBody PrediccionDTO prediccionDTO) {
		return iPrediccionService.createPrediccion(prediccionDTO);
	}
    
    @DeleteMapping("/prediccion/delete")
	public void deletePrediccion(@PathVariable Integer id_prediccion) {
        iPrediccionService.deletePrediccion(id_prediccion);
    }
    
    @PutMapping("/prediccion/update")
	public PrediccionDTO updatePrediccion(@RequestBody PrediccionDTO prediccionDTO) {
		return iPrediccionService.updatePrediccion(prediccionDTO);
	}

}