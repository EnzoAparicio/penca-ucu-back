package uy.edu.ucu.pencaucu.dto;

import lombok.Data;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.model.Torneo;
import uy.edu.ucu.pencaucu.model.Usuario;

@Data
public class TorneoUsuarioDTO {

	private Integer idTorneoUsuario;

	private Usuario usuario;

	private Torneo torneo;

	private Equipo campeon;

	private Equipo subcampeon;

	private Integer puntos;
}
