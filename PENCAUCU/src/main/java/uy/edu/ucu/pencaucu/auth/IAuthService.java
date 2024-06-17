package uy.edu.ucu.pencaucu.auth;

import uy.edu.ucu.pencaucu.dto.UsuarioDTO;

public interface IAuthService {

	AuthResponse loginUsuario(UsuarioDTO usuarioDTO);

	AuthResponse createUsuario(UsuarioDTO usuarioDTO);

}
