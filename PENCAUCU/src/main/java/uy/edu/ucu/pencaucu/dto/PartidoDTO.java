package uy.edu.ucu.pencaucu.dto;

import java.util.Date;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Estadio;
import uy.edu.ucu.pencaucu.model.Torneo;

@Data
public class PartidoDTO {

    private Integer id_partido;

    private Date fecha;

    private Estadio estadio;

    private Torneo torneo;
}
