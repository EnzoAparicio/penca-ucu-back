package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.service.ITorneoService;

@Controller
public class TorneoController {
	@Autowired
	ITorneoService iTorneoService;
	
	/**
	 * Solicita la creación de un Torneo a partir del objeto recibido.
	 * 
	 * @param torneoDTO - Body de la request.
	 * @return TorneoDTO creado o null si ocurre un error.
	 */
	@PostMapping(path = "/Torneo/Create")
	public TorneoDTO createTorneo(@RequestBody TorneoDTO torneoDTO) {
		return iTorneoService.createTorneo(torneoDTO);
	}
	
	
	/**
	 * Solicita la actualización de un Torneo a partir del Id.
	 * 
	 * @param torneoDTO - Body de la request.
	 * @return TorneoDTO actualizado o null si ocurre un error.
	 */
	@PutMapping(path = "/Torneo/Update")
	public TorneoDTO updateTorneo(@RequestBody TorneoDTO torneoDTO) {
		return iTorneoService.updateTorneo(torneoDTO);
	}
	
	/**
	 * Solicita la eliminación de un Torneo a partir del Body de la request.
	 * 
	 * Ignora silenciosamente si el Torneo con ese Id no existe.
	 * 
	 * @param torneoDTO - Body de la request.
	 */
	@DeleteMapping(path = "/Torneo/Delete")
	public void deleteTorneo(@RequestBody TorneoDTO torneoDTO) {
		iTorneoService.deleteTorneo(torneoDTO);
	}
	
	/**
	 * Solicita un Torneo por su Id.
	 * 
	 * @param id_torneo - Path de la request.
	 * @return TorneoDTO que coincida o null si no existe.
	 */
	@GetMapping(path = "/Torneo/{id_torneo}")
	public TorneoDTO getTorneo(@PathVariable Integer id_torneo) {
		return iTorneoService.getTorneo(id_torneo);
	}
	/**
	 * Solicita todas las entradas de Torneo en la Base de Datos que coincidan.
	 * 
	 * @param TorneoDTO - nullable - Body de la request.
	 * @return List<TorneoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	@GetMapping(path = "/Torneo/getAll")
	public List<TorneoDTO> getAllTorneo(@RequestBody(required = false) TorneoDTO torneoDTO) {
		return iTorneoService.getAllTorneo(torneoDTO);
	}
	
	
}
