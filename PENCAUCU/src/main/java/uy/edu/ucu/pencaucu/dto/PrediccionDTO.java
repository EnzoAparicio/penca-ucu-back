package uy.edu.ucu.pencaucu.dto;	

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Usuario;	

@Data	
public class PrediccionDTO {	

    private Integer id_prediccion;	

    private Integer prediccion_e1;	

    private Integer prediccion_e2;	

    private String ganador;	
    
    private Equipo equipo1;

    private Equipo equipo2;
    
    private Usuario usuario;
}
