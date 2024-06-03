package uy.edu.ucu.pencaucu.dto;	

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Usuario;
import uy.edu.ucu.pencaucu.model.Partido;

@Data	
public class PrediccionDTO {	

    private Integer id_prediccion;	

    private Integer prediccion_equipo1;	

    private Integer prediccion_equipo2;	

    private Equipo ganador;	
    
    private Partido partido;
    
    private Usuario usuario;
}
