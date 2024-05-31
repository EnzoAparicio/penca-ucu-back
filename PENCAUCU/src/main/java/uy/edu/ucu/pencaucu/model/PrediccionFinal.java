package uy.edu.ucu.pencaucu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prediccion_final")
public class PrediccionFinal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prediccion_final")
	private Integer id_prediccion_final;
	
	// No lleva anotacion porque Usuario es duenio de la prediccion.
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_torneo")
	private Torneo torneo;
	
	@ManyToOne
	@JoinColumn(name = "id_campeon", referencedColumnName = "id_equipo")
	private Equipo campeon;
	
	@ManyToOne
	@JoinColumn(name = "id_subcampeon", referencedColumnName = "id_equipo")
	private Equipo subcampeon;
}
