package uy.edu.ucu.pencaucu.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "torneo")
public class Torneo {
	
	@Id 
	@Column(name="id_torneo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTorneo;
	
	@Column (name="nombre", length=100, nullable=false)
	private String nombre;
	
	@Column (name="anio",length=30)
	private String anio;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "idTorneo")
	private List<Partido> partidos;
}
