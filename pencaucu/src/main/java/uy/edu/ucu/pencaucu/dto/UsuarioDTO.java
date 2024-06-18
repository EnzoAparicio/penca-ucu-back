package uy.edu.ucu.pencaucu.dto;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Carrera;

@Data
public class UsuarioDTO {

	private Integer idUsuario;
	
	private String email;
	
	private String contrasenia;
	
	private String nombre;
	
	private String apellido;
	
	private String avatarPath;
	
	private Carrera carrera;
	
	private Boolean esAdministrador;
}
