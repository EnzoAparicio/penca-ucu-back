package uy.edu.ucu.pencaucu.dto;

import java.util.List;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Carrera;
import uy.edu.ucu.pencaucu.model.Prediccion;

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
	
	private List<Prediccion> predicciones;
}
