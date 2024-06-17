package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.service.ITorneoUsuarioService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class TorneoUsuarioController {

	@Autowired
	ITorneoUsuarioService iTorneoUsuarioService;
	
	@GetMapping("/torneoUsuario/getAllByTorneo/{id_torneo}")
	public ResponseEntity<List<TorneoUsuarioDTO>> getAllByTorneo(@PathVariable Integer id_torneo) {
		try {
			List<TorneoUsuarioDTO> torneoUsuarioDTOList = iTorneoUsuarioService.getAllByTorneo(id_torneo);
			if (!torneoUsuarioDTOList.isEmpty()) {
				return ResponseUtil.okResponse(torneoUsuarioDTOList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
