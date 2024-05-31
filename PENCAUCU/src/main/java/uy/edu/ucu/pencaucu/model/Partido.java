package uy.edu.ucu.pencaucu.model;

import java.util.Date; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Table(name = "partido")
@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partido")
	private Integer id_partido;

	@Column(name = "resultado_e1")
	private Integer resultado_e1;

	@Column(name = "resultado_e2")
	private Integer resultado_e2;

	@Column(name = "fecha")
	private Date fecha;
	
	//@ManyToOne
	//@JoinColumn(name="id_estadio", nullable=false)
	//private Estadio estadio;
	
	@Column(name = "id_equipo1")
	private Integer id_equipo1;
	
	@Column(name = "id_equipo2")
	private Integer id_equipo2;
	
	@Column(name = "id_torneo")
	private Integer id_torneo;

}