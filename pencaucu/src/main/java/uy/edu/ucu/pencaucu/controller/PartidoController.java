package uy.edu.ucu.pencaucu.controller;

import java.util.ArrayList;
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

import uy.edu.ucu.pencaucu.dto.EquipoPartidoDTO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.model.Partido;
import uy.edu.ucu.pencaucu.service.IEquipoPartidoService;
import uy.edu.ucu.pencaucu.service.IPartidoService;
import uy.edu.ucu.pencaucu.util.DozerUtil;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class PartidoController {

	@Autowired
	private IPartidoService iPartidoService;
	
	@Autowired
	private IEquipoPartidoService iEquipoPartidoService;

	private ResponseEntity<PartidoDTO> checkResponse(PartidoDTO partido) {
		if (partido.getIdPartido() != null) {
			return ResponseUtil.okResponse(partido);
		} else {
			return ResponseUtil.badRequest();
		}
	}

	/**
	 * Crea un nuevo partido.
	 * 
	 * @param partidoDTO Datos del partido a crear.
	 * @return Partido creado.
	 */
	@PostMapping("/partido/create")
	public ResponseEntity<PartidoDTO> createPartido(@RequestBody PartidoDTO partidoDTO) {
		try {
			return checkResponse(iPartidoService.createPartido(partidoDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Actualiza un partido existente.
	 * 
	 * @param partidoDTO Datos del partido a actualizar.
	 * @return Partido actualizado.
	 */
	@PutMapping("/partido/update")
	public ResponseEntity<PartidoDTO> updatePartido(@RequestBody PartidoDTO partidoDTO) {
		try {
			PartidoDTO newPartido = iPartidoService.updatePartido(partidoDTO);
			if (newPartido.getIdPartido() != null) {

				newPartido.setEquipos(partidoDTO.getEquipos());
				List<EquipoPartido> newRelationList = new ArrayList<EquipoPartido>();
				
				for (EquipoPartido relation : newPartido.getEquipos()) {
					relation.setPartido(DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class));
					EquipoPartidoDTO equipoPartidoDTO = iEquipoPartidoService.updateEquipoPartido(DozerUtil.GetINSTANCE().getMapper().map(relation, EquipoPartidoDTO.class)); 
					newRelationList.add(DozerUtil.GetINSTANCE().getMapper().map(equipoPartidoDTO, EquipoPartido.class));
				}
				
				newPartido.setEquipos(newRelationList);
			}
			return checkResponse(newPartido);
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Elimina un partido.
	 * 
	 * @param partidoDTO Datos del partido a eliminar.
	 */
	@DeleteMapping("/partido/delete")
	public void deletePartido(@RequestBody PartidoDTO partidoDTO) {
		iPartidoService.deletePartido(partidoDTO);
	}

	/**
	 * Obtiene un partido por su identificador.
	 * 
	 * @param id_partido Identificador del partido.
	 * @return Partido encontrado.
	 */
	@GetMapping("/partido/{id_partido}")
	public ResponseEntity<PartidoDTO> getPartido(@PathVariable Integer id_partido) {
		try {
			PartidoDTO partidoDTO = iPartidoService.getPartido(id_partido);
			if (partidoDTO.getIdPartido() != null) {
				return ResponseUtil.okResponse(partidoDTO);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Obtiene todos los partidos, opcionalmente filtrados por los datos
	 * proporcionados.
	 * 
	 * @param partidoDTO Filtros de búsqueda opcionales.
	 * @return Lista de partidos.
	 */
	@GetMapping("/partido/getAll")
	public ResponseEntity<List<PartidoDTO>> getAllPartido(@RequestBody(required = false) PartidoDTO partidoDTO) {
		try {
			List<PartidoDTO> partidoDTOList = iPartidoService.getAllPartido(partidoDTO);
			if (!partidoDTOList.isEmpty()) {
				return ResponseUtil.okResponse(partidoDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Obtiene todos los partidos ya finalizados de un torneo en la fecha ingresada.
	 * 
	 * @param date      - fecha de comparacion.
	 * @param torneoDTO - torneo a buscar.
	 * @return Lista de partidos que coincidan.
	 */
	@GetMapping("/partido/getAllFinished")
	public ResponseEntity<List<PartidoDTO>> getAllFinishedPartido(@RequestBody PartidoDTO partidoDTO) {
		try {
			List<PartidoDTO> partidoDTOList = iPartidoService.getAllFinishedPartido(partidoDTO.getFecha(),
					partidoDTO.getIdTorneo());
			if (!partidoDTOList.isEmpty()) {
				return ResponseUtil.okResponse(partidoDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	/**
	 * Obtiene todos los partidos aun no finalizados de un torneo en la fecha
	 * ingresada.
	 * 
	 * @param date      - fecha de comparacion.
	 * @param torneoDTO - torneo a buscar.
	 * @return Lista de partidos que coincidan.
	 */
	@GetMapping("/partido/getAllFuture")
	public ResponseEntity<List<PartidoDTO>> getAllFuturePartido(@RequestBody PartidoDTO partidoDTO) {
		try {
			List<PartidoDTO> partidoDTOList = iPartidoService.getAllFuturePartido(partidoDTO.getFecha(),
					partidoDTO.getIdTorneo());
			if (!partidoDTOList.isEmpty()) {
				return ResponseUtil.okResponse(partidoDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
