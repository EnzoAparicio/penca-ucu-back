package uy.edu.ucu.PENCAUCU.dto;

import lombok.Data;
import uy.edu.ucu.PENCAUCU.model.Carrera;

@Data
public class UsuarioDTO {

	private Integer id_usuario;
	
	private String nombre;
	
	private String apellido;
	
	private String avatar_path;
	
	//private Carrera carrera;
	
	private Integer puntos;
	
	private String email;
	
	private String contrasenia;
}
