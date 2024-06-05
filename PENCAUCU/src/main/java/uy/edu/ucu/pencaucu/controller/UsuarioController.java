package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;
	
	@PostMapping("/usuario/create") // Enviar un json con los atributos de un usuario y sus respectivos valores.
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			usuarioDTO = iUsuarioService.createUsuario(usuarioDTO); 
			if (usuarioDTO.getId_usuario() != null) {
				return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatusCode.valueOf(200));
			} else {
				return new ResponseEntity<UsuarioDTO>(HttpStatusCode.valueOf(204));
			}
		} catch (Error e) {
			return new ResponseEntity<UsuarioDTO>(HttpStatusCode.valueOf(500));
		}
	}
	
	@PostMapping("/usuario/login") // Enviar un json con los atributos para logear y sus valores.
	public boolean loginUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return iUsuarioService.loginUsuario(usuarioDTO);
	}
	
	@PutMapping("/usuario/update")
	public UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return iUsuarioService.updateUsuario(usuarioDTO);
	}
	
	@DeleteMapping("/usuario/delete")
	public void deleteUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		iUsuarioService.deleteUsuario(usuarioDTO);
	}
	
	@GetMapping("/usuario/{id_usuario}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Integer id_usuario) {
		try {
			UsuarioDTO usuarioDTO = iUsuarioService.getUsuario(id_usuario);
			if (usuarioDTO.getId_usuario() != null) {
				return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatusCode.valueOf(200));
			} else {
				return new ResponseEntity<UsuarioDTO>(HttpStatusCode.valueOf(204));
			}
		} catch (Error e) {
			return new ResponseEntity<UsuarioDTO>(HttpStatusCode.valueOf(500));
		}
	}
	
	@GetMapping("/usuario/getAll")
	public List<UsuarioDTO> getAllUsuario(@RequestBody(required = false) UsuarioDTO usuarioDTO) {
		return iUsuarioService.getAllUsuario(usuarioDTO);
	}
}
