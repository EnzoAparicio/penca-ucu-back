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

import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.service.ITorneoService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class TorneoController {
	
	@Autowired
	ITorneoService iTorneoService;
	
	private ResponseEntity<TorneoDTO> checkResponse(TorneoDTO torneo) {
		if (torneo.getIdTorneo() != null) {
			return ResponseUtil.okResponse(torneo);
		} else {
			return ResponseUtil.badRequest();
		}
	}
	
	/**
	 * Solicita la creación de un Torneo a partir del objeto recibido.
	 * 
	 * @param torneoDTO - Body de la request.
	 * @return TorneoDTO creado o null si ocurre un error.
	 */
	@PostMapping("/torneo/create")
	public ResponseEntity<TorneoDTO> createTorneo(@RequestBody TorneoDTO torneoDTO) {
		try {
			return checkResponse(iTorneoService.createTorneo(torneoDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
	
	
	/**
	 * Solicita la actualización de un Torneo a partir del Id.
	 * 
	 * @param torneoDTO - Body de la request.
	 * @return TorneoDTO actualizado o null si ocurre un error.
	 */
	@PutMapping("/torneo/update")
	public ResponseEntity<TorneoDTO> updateTorneo(@RequestBody TorneoDTO torneoDTO) {
		try {
			return checkResponse(iTorneoService.updateTorneo(torneoDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
	
	/**
	 * Solicita la eliminación de un Torneo a partir del Body de la request.
	 * 
	 * Ignora silenciosamente si el Torneo con ese Id no existe.
	 * 
	 * @param torneoDTO - Body de la request.
	 */
	@DeleteMapping("/torneo/delete")
	public void deleteTorneo(@RequestBody TorneoDTO torneoDTO) {
		iTorneoService.deleteTorneo(torneoDTO);
	}
	
	/**
	 * Solicita un Torneo por su Id.
	 * 
	 * @param id_torneo - Path de la request.
	 * @return TorneoDTO que coincida o null si no existe.
	 */
	@GetMapping("/torneo/{id_torneo}")
	public ResponseEntity<TorneoDTO> getTorneo(@PathVariable Integer id_torneo) {
		try {
			TorneoDTO torneoDTO = iTorneoService.getTorneo(id_torneo);
			if (torneoDTO.getIdTorneo() != null) {
				return ResponseUtil.okResponse(torneoDTO);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
	/**
	 * Solicita todas las entradas de Torneo en la Base de Datos que coincidan.
	 * 
	 * @param TorneoDTO - nullable - Body de la request.
	 * @return List<TorneoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	@GetMapping("/torneo/getAll")
	public ResponseEntity<List<TorneoDTO>> getAllTorneo(@RequestBody(required = false) TorneoDTO torneoDTO) {
		try {
			List<TorneoDTO> torneoDTOList = iTorneoService.getAllTorneo(torneoDTO); 
			if ( !torneoDTOList.isEmpty() ) {
				return ResponseUtil.okResponse(torneoDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
