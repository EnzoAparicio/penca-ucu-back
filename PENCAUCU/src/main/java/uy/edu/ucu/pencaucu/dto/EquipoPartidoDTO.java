package uy.edu.ucu.pencaucu.dto;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Partido;

@Data
public class EquipoPartidoDTO {

    private Integer idEquipoPartido;

    private Partido partido;

    private Equipo equipo;

    private Integer tipoEquipo;
    
    private Integer resultado;
}
