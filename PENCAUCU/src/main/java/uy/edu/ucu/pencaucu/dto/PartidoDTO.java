package uy.edu.ucu.pencaucu.dto;

import java.util.Date;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Estadio;

@Data
public class PartidoDTO {

    private Integer id_partido;
     
    private Integer resultado_e1;

    private Integer resultado_e2;

    private Date fecha;

    private Estadio estadio;

    private Equipo equipo1;

    private Equipo equipo2;

//    private Torneo id_torneo;
}
