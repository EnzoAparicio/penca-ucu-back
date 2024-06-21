package uy.edu.ucu.pencaucu.dto;	

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Partido;

@Data	
public class PrediccionDTO {	

    private Integer idPrediccion;	

    private Integer prediccionEquipo1;	

    private Integer prediccionEquipo2;		
    
    private Partido partido;

    private Integer idUsuario;
    
    private Integer puntos;
}
