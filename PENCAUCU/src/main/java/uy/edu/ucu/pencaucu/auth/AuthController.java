package uy.edu.ucu.pencaucu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.ucu.pencaucu.util.ResponseUtil;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;

@RestController
public class AuthController {
	
	@Autowired
	private IAuthService iAuthService;
	
	@PostMapping("/usuario/create") // Enviar un json con los atributos de un usuario y sus respectivos valores.
	public ResponseEntity<AuthResponse> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return ResponseEntity.ok(iAuthService.createUsuario(usuarioDTO)); 
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}

	@PostMapping("/usuario/login") // Enviar un json con los atributos para logear y sus valores.
	public ResponseEntity<AuthResponse> loginUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return ResponseEntity.ok(iAuthService.loginUsuario(usuarioDTO));
		} catch (Error e) {
			return ResponseUtil.internalError();
		}
	}
		
}