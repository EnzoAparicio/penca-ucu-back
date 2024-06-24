package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.EquipoDTO;
import uy.edu.ucu.pencaucu.service.IEquipoService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class EquipoController {

	@Autowired
	IEquipoService iEquipoService;

	private ResponseEntity<EquipoDTO> checkResponse(EquipoDTO equipo) {
		if (equipo.getIdEquipo() != null) {
			return ResponseUtil.okResponse(equipo);
		} else {
			return ResponseUtil.badRequest();
		}
	}

	/**
	 * Solicita la creación de un Equipo a partir del objeto recibido.
	 * 
	 * @param equipoDTO - Body de la request.
	 * @return EquipoDTO creado o null si ocurre un error.
	 */
	@PostMapping("/equipo/create")
	public ResponseEntity<EquipoDTO> createEquipo(@RequestBody EquipoDTO equipoDTO) {
		try {
			return checkResponse(iEquipoService.createEquipo(equipoDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Solicita la actualización de un Equipo a partir del Id.
	 * 
	 * @param equipoDTO - Body de la request.
	 * @return EquipoDTO actualizado o null si ocurre un error.
	 */
	@PutMapping("/equipo/update")
	public ResponseEntity<EquipoDTO> updateEquipo(@RequestBody EquipoDTO equipoDTO) {
		try {
			return checkResponse(iEquipoService.updateEquipo(equipoDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Solicita la eliminación de un Equipo a partir del Body de la request.
	 * 
	 * Ignora silenciosamente si el Equipo con ese Id no existe.
	 * 
	 * @param equipoDTO - Body de la request.
	 */
	@DeleteMapping("/equipo/delete")
	public void deleteEquipo(@RequestBody EquipoDTO equipoDTO) {
		iEquipoService.deleteEquipo(equipoDTO);
	}

	/**
	 * Solicita un Equipo por su Id.
	 * 
	 * @param id_equipo - Path de la request.
	 * @return EquipoDTO que coincida o null si no existe.
	 */
	@GetMapping("/equipo/{id_equipo}")
	public ResponseEntity<EquipoDTO> getEquipo(@PathVariable Integer id_equipo) {
		try {
			EquipoDTO equipoDTO = iEquipoService.getEquipo(id_equipo);
			if (equipoDTO.getIdEquipo() != null) {
				return ResponseUtil.okResponse(equipoDTO);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Solicita todas las entradas de Equipo en la Base de Datos que coincidan.
	 * 
	 * @param equipoDTO - nullable - Body de la request.
	 * @return List<EquipoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	@GetMapping("/equipo/getAll")
	public ResponseEntity<List<EquipoDTO>> getAllEquipo(@RequestBody(required = false) EquipoDTO equipoDTO) {
		try {
			List<EquipoDTO> equipoDTOList = iEquipoService.getAllEquipo(equipoDTO);
			if (!equipoDTOList.isEmpty()) {
				return ResponseUtil.okResponse(equipoDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
