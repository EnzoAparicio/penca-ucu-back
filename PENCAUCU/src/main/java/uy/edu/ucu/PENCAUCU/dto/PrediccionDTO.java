package uy.edu.ucu.pencaucu.dto;

import lombok.Data;

@Data
public class PrediccionDTO {
    
    private Integer id_prediccion;

    private Integer prediccion_e1;

    private Integer prediccion_e2;

    private String ganador;
    
    
}