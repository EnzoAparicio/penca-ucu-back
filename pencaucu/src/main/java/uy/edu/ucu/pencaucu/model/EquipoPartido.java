package uy.edu.ucu.pencaucu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "equipo_partido")
public class EquipoPartido {

	@Id
	@Column(name = "id_equipo_partido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipoPartido;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_partido")
	private Partido partido;

	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;

	// Asocia un numero al equipo (1 o 2) para relacionarlo con las predicciones.
	@Column(name = "tipo_equipo")
	private Integer tipoEquipo;

	@Column(name = "resultado")
	private Integer resultado;
}
