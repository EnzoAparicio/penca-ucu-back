package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.service.ITorneoUsuarioService;
import uy.edu.ucu.pencaucu.util.ResponseUtil;

@RestController
public class TorneoUsuarioController {

	@Autowired
	ITorneoUsuarioService iTorneoUsuarioService;
	
	@PostMapping("/torneoUsuario/create")
	public ResponseEntity<TorneoUsuarioDTO> createTorneoUsuario(@RequestBody TorneoUsuarioDTO torneoUsuarioDTO) {
		try {
			System.out.println("\nCorrect endpoint.");
			torneoUsuarioDTO = iTorneoUsuarioService.createTorneoUsuario(torneoUsuarioDTO);
			if (torneoUsuarioDTO.getIdTorneoUsuario() != null) {
				return ResponseUtil.okResponse(torneoUsuarioDTO);
			} else {
				return ResponseUtil.badRequest();
			}
		} catch(Error e) {
			return ResponseUtil.internalError();
		}
	}
	
	@GetMapping("/torneoUsuario/getAllByIdTorneo/{id_torneo}")
	public ResponseEntity<List<TorneoUsuarioDTO>> getAllByIdTorneo(@PathVariable Integer id_torneo) {
		try {
			List<TorneoUsuarioDTO> torneoUsuarioDTOList = iTorneoUsuarioService.getAllByIdTorneo(id_torneo);
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
