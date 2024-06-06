package uy.edu.ucu.pencaucu.dto;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Partido;

@Data
public class EquipoPartidoDTO {

    private Integer id_equipo_partido;

    private Partido partido;

    private Equipo equipo;

    private Integer tipo_equipo;

}
