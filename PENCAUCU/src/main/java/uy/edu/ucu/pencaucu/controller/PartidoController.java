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
import uy.edu.ucu.pencaucu.service.IPartidoService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;


@RestController
public class PartidoController {

    @Autowired
    private IPartidoService iPartidoService;
    
    private ResponseEntity<PartidoDTO> checkResponse(PartidoDTO partido) {
		if (partido.getId_partido() != null) {
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
    		return checkResponse(iPartidoService.updatePartido(partidoDTO));
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
    		if (partidoDTO.getId_partido() != null) {
    			return ResponseUtil.okResponse(partidoDTO);
    		} else {
    			return ResponseUtil.noContent();
    		}
    	} catch (Error e) {
    		return ResponseUtil.internalError();
    	}
    }

    /**
     * Obtiene todos los partidos, opcionalmente filtrados por los datos proporcionados.
     * 
     * @param partidoDTO Filtros de búsqueda opcionales.
     * @return Lista de partidos.
     */
    @GetMapping("/partido/getAll")
    public ResponseEntity<List<PartidoDTO>> getAllPartido(@RequestBody(required = false) PartidoDTO partidoDTO) {
    	
    	try {
    		List<PartidoDTO> partidoDTOList = iPartidoService.getAllPartido(partidoDTO);
    		if ( !partidoDTOList.isEmpty() ) {
    			return ResponseUtil.okResponse(partidoDTOList);
    		} else {
    			return ResponseUtil.noContent();
    		}
    	} catch (Error e) {
    		return ResponseUtil.internalError();
    	}
    }
    
    /**
     * Obtiene un partido con su estadistica y un status code.
     * @param id_partido - Id del partido a analizar.
     * @return partido con estadisticas de ser correcto y status code.
     */
    @GetMapping("/partido/getEstadistica/{id_partido}")
    public ResponseEntity<HashMap<String, Integer>> getEstadisticaPartido(@PathVariable Integer id_partido){
    	try {
    		HashMap<String, Integer> estadistica = iPartidoService.getEstadisticaPartido(id_partido);
    		if (!estadistica.isEmpty()) {
    			return ResponseUtil.okResponse(estadistica);
    		} else {
    			return ResponseUtil.badRequest();
    		}
    	} catch (Error e) {
    		return ResponseUtil.internalError();
    	}
    }
}
