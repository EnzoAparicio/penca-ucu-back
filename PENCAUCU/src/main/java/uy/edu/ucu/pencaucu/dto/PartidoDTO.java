package uy.edu.ucu.pencaucu.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.model.Estadio;

@Data
public class PartidoDTO {

    private Integer id_partido;

    private Date fecha;

    private Estadio estadio;

    private Integer id_torneo;
    
    private List<EquipoPartido> equipos;
}
