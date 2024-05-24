package uy.edu.ucu.PENCAUCU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.PENCAUCU.model.Prediccion;
import uy.edu.ucu.PENCAUCU.repo.IPrediccionRepo;

@RestController
@RequestMapping("/api")
public class PrediccionController {
    @Autowired
    private IPrediccionRepo repo;

    @GetMapping("/prediccion")
    public List<Prediccion> allPredicciones() {
        return repo.findAll();
    }

    @GetMapping("/prediccion/{id}")
    public Prediccion getPrediccion(@PathVariable Integer id) {
        return repo.findById(id).get();
    }
    
    @PostMapping("/prediccion")
	public Prediccion createPrediccion(@RequestBody Prediccion prediccion) {
		return repo.save(prediccion);
	}
    
    @DeleteMapping("/prediccion/{id}")
	public String deletePrediccion(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return "La predicción se borró exitosamente";
	}
    
    @PutMapping("/prediccion")
	public Prediccion updatePrediccion(@RequestBody Prediccion prediccion) {
		return repo.save(prediccion);
	}

}