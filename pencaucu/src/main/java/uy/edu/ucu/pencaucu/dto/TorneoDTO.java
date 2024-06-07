package uy.edu.ucu.pencaucu.dto;


import java.util.List;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Partido;

@Data
public class TorneoDTO {
	
	private Integer id_torneo;
	
	private String nombre;
	
	private String anio;
	
	private List<Partido> partidos;
}
