package uy.edu.ucu.pencaucu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return iUsuarioService.createUsuario(usuarioDTO);
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
	public UsuarioDTO getUsuario(@PathVariable Integer id_usuario) {
		return iUsuarioService.getUsuario(id_usuario);
	}
	
	@GetMapping("/usuario/getAll")
	public List<UsuarioDTO> getAllUsuario(@RequestBody(required = false) UsuarioDTO usuarioDTO) {
		return iUsuarioService.getAllUsuario(usuarioDTO);
	}
}
