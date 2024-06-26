package uy.edu.ucu.pencaucu.controller;

import java.util.HashMap;
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

import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.PrediccionDTO;
import uy.edu.ucu.pencaucu.service.IPrediccionService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class PrediccionController {

	@Autowired
	private IPrediccionService iPrediccionService;

	private ResponseEntity<PrediccionDTO> checkResponse(PrediccionDTO prediccion) {
		if (prediccion.getIdPrediccion() != null) {
			return ResponseUtil.okResponse(prediccion);
		} else {
			return ResponseUtil.badRequest();
		}
	}

	@GetMapping("/prediccion/getAll") // Envia un json con todas las predicciones
	public ResponseEntity<List<PrediccionDTO>> getAllPrediccion(
			@RequestBody(required = false) PrediccionDTO prediccionDTO) {
		try {
			List<PrediccionDTO> prediccionDTOList = iPrediccionService.getAllPrediccion(prediccionDTO);
			if (!prediccionDTOList.isEmpty()) {
				return ResponseUtil.okResponse(prediccionDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@GetMapping("/prediccion/{id_prediccion}") // Envia un json con la prediccion que tiene el id indicado
	public ResponseEntity<PrediccionDTO> getPrediccion(@PathVariable Integer id_prediccion) {
		try {
			PrediccionDTO prediccionDTO = iPrediccionService.getPrediccion(id_prediccion);
			if (prediccionDTO.getIdPrediccion() != null) {
				return ResponseUtil.okResponse(prediccionDTO);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@PostMapping("/prediccion/create") // Crea una prediccion y la devuelve en un json
	public ResponseEntity<PrediccionDTO> createPrediccion(@RequestBody PrediccionDTO prediccionDTO) {
		try {
			return checkResponse(iPrediccionService.createPrediccion(prediccionDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@DeleteMapping("/prediccion/delete") // Elimina la prediccion con el id indicado
	public void deletePrediccion(@RequestBody PrediccionDTO prediccionDTO) {
		iPrediccionService.deletePrediccion(prediccionDTO);
	}

	@PutMapping("/prediccion/update") // Actualiza la prediccion con los datos del json y la devuelve
	public ResponseEntity<PrediccionDTO> updatePrediccion(@RequestBody PrediccionDTO prediccionDTO) {
		try {
			return checkResponse(iPrediccionService.updatePrediccion(prediccionDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Obtiene la estadistica de un partido con su status code.
	 * 
	 * @param id_partido - Id del partido a analizar.
	 * @return Estadisticas de equipo1, equipo2 y empate y status code.
	 */
	@GetMapping("/prediccion/getEstadistica/{id_partido}")
	public ResponseEntity<HashMap<String, Integer>> getEstadisticaPartido(@PathVariable Integer id_partido) {
		try {
			return ResponseUtil.okResponse(iPrediccionService.getEstadisticaPartido(id_partido));
		} catch (Error e) {
			System.out.println("\nnError: " + e.toString());
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Recibe un partido con un resultado y recorre todas las predicciones para
	 * asignar los puntos correspondientes.
	 * 
	 * @param partidoDTO - Partido finalizado con un resultado.
	 */
	@PostMapping("/prediccion/checkResultado")
	public void checkResultado(@RequestBody PartidoDTO partidoDTO) {
		iPrediccionService.checkResultado(partidoDTO);
	}
	
	/**
	 * Recibe un id de usuario y devuelve todas sus predicciones.
	 * 
	 * @param id_usuario
	 * @return List<PrediccionDTO>
	 */
	@GetMapping("/prediccion/getAllByUsuario/{id_usuario}")
	public ResponseEntity<List<PrediccionDTO>> getAllByIdUsuario(@PathVariable Integer id_usuario) {
		try {
			List<PrediccionDTO> prediccionList = iPrediccionService.getAllByIdUsuario(id_usuario); 
			if (!prediccionList.isEmpty()) {
				return ResponseUtil.okResponse(prediccionList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
