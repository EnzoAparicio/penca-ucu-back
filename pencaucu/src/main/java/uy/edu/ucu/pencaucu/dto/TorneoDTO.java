package uy.edu.ucu.pencaucu.dto;


import java.util.List;

import lombok.Data;
@Data
public class TorneoDTO {
	
	private Integer idTorneo;
	
	private String nombre;
	
	private String anio;
	
	private List<PartidoDTO> partidos;
}
