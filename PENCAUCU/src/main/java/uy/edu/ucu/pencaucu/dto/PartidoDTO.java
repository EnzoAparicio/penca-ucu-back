package uy.edu.ucu.pencaucu.dto;

import java.util.Date;


import lombok.Data;
//import uy.edu.ucu.pencaucu.model.Estadio;

@Data
public class PartidoDTO {

	private Integer id_partido;
	
	private Integer resultado_e1;
	
	private Integer resultado_e2;
	
	private Date fecha;
	
	//private Estadio estadio;
	
	private Integer id_equipo1;
	
	private Integer id_equipo2;
	
	private Integer id_torneo;
	
}