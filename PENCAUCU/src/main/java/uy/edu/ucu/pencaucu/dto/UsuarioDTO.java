package uy.edu.ucu.pencaucu.dto;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Carrera;

@Data
public class UsuarioDTO {

	private Integer id_usuario;
	
	private String email;
	
	private String contrasenia;
	
	private String nombre;
	
	private String apellido;
	
	private String avatar_path;
	
	private Carrera carrera;
	
	private Boolean es_administrador;
	
//	private List<Prediccion> predicciones;
}
