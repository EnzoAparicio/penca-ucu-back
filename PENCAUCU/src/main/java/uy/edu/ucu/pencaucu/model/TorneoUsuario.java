package uy.edu.ucu.pencaucu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "torneo_usuario")
public class TorneoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_torneo_usuario")
	private Integer idTorneoUsuario;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_torneo")
	private Torneo torneo;
	
	@ManyToOne
	@JoinColumn(name = "id_campeon", referencedColumnName = "id_equipo")
	private Equipo campeon;
	
	@ManyToOne
	@JoinColumn(name = "id_subcampeon", referencedColumnName = "id_equipo")
	private Equipo subcampeon;
	
	@Column(name = "puntos")
	private Integer puntos;
}
