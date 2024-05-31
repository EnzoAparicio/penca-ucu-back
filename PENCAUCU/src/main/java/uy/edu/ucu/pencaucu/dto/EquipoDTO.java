package uy.edu.ucu.pencaucu.dto;

import java.util.List;
import lombok.Data;

@Data
public class EquipoDTO {

	private Integer id_equipo;
	
	private String nombre;
	
	private String img_bandera;
	
	private String color;
	
//	private List<Partido> partidos;
}
