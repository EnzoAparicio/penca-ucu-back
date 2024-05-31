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

import uy.edu.ucu.pencaucu.dto.EquipoDTO;
import uy.edu.ucu.pencaucu.service.IEquipoService;

@Controller
public class EquipoController {
	
	@Autowired
	IEquipoService iEquipoService;
	
	/**
	 * Solicita la creación de un Equipo a partir del objeto recibido.
	 * 
	 * @param equipoDTO - Body de la request.
	 * @return EquipoDTO creado o null si ocurre un error.
	 */
	@PostMapping(path = "/Equipo/Create")
	public EquipoDTO createEquipo(@RequestBody EquipoDTO equipoDTO) {
		return iEquipoService.createEquipo(equipoDTO);
	}
	
	/**
	 * Solicita la actualización de un Equipo a partir del Id.
	 * 
	 * @param equipoDTO - Body de la request.
	 * @return EquipoDTO actualizado o null si ocurre un error.
	 */
	@PutMapping(path = "/Equipo/Update")
	public EquipoDTO updateEquipo(@RequestBody EquipoDTO equipoDTO) {
		return iEquipoService.updateEquipo(equipoDTO);
	}
	
	/**
	 * Solicita la eliminación de un Equipo a partir del Body de la request.
	 * 
	 * Ignora silenciosamente si el Equipo con ese Id no existe.
	 * 
	 * @param equipoDTO - Body de la request.
	 */
	@DeleteMapping(path = "/Equipo/Delete")
	public void deleteEquipo(@RequestBody EquipoDTO equipoDTO) {
		iEquipoService.deleteEquipo(equipoDTO);
	}
	
	/**
	 * Solicita un Equipo por su Id.
	 * 
	 * @param id_equipo - Path de la request.
	 * @return EquipoDTO que coincida o null si no existe.
	 */
	@GetMapping(path = "/Equipo/{id_equipo}")
	public EquipoDTO getEquipo(@PathVariable Integer id_equipo) {
		return iEquipoService.getEquipo(id_equipo);
	}
	
	/**
	 * Solicita todas las entradas de Equipo en la Base de Datos que coincidan.
	 * 
	 * @param equipoDTO - nullable - Body de la request.
	 * @return List<EquipoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	@GetMapping(path = "/Equipo/getAll")
	public List<EquipoDTO> getAllEquipo(@RequestBody(required = false) EquipoDTO equipoDTO) {
		return iEquipoService.getAllEquipo(equipoDTO);
	}
}
