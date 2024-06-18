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
import uy.edu.ucu.pencaucu.util.ResponseUtil;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;
	
	private ResponseEntity<UsuarioDTO> checkResponse(UsuarioDTO usuario) {
		if (usuario.getIdUsuario() != null) {
			return ResponseUtil.okResponse(usuario);
		} else {
			return ResponseUtil.badRequest();
		}
	}
	
	@PostMapping("/usuario/create") // Enviar un json con los atributos de un usuario y sus respectivos valores.
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return checkResponse(iUsuarioService.createUsuario(usuarioDTO)); 
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@PostMapping("/usuario/login") // Enviar un json con los atributos para logear y sus valores.
	public ResponseEntity<UsuarioDTO> loginUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return checkResponse(iUsuarioService.loginUsuario(usuarioDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@PutMapping("/usuario/update")
	public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return checkResponse(iUsuarioService.updateUsuario(usuarioDTO)); 
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
	
	@DeleteMapping("/usuario/delete")
	public void deleteUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		iUsuarioService.deleteUsuario(usuarioDTO);
	}
	
	@GetMapping("/usuario/{id_usuario}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Integer id_usuario) {
		try {
			UsuarioDTO usuarioDTO = iUsuarioService.getUsuario(id_usuario);
			if (usuarioDTO.getIdUsuario() != null) {
				return ResponseUtil.okResponse(usuarioDTO);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
	
	@GetMapping("/usuario/getAll")
	public ResponseEntity<List<UsuarioDTO>> getAllUsuario(@RequestBody(required = false) UsuarioDTO usuarioDTO) {
		try {
			List<UsuarioDTO> usuarioList = iUsuarioService.getAllUsuario(usuarioDTO);
			if (!usuarioList.isEmpty()) {
				return ResponseUtil.okResponse(usuarioList);
			} else {
				return ResponseUtil.noContent();
			}
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
}
