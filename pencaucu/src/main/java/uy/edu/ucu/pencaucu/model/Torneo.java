package uy.edu.ucu.pencaucu.model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Table(name="torneo")
@Entity
public class Torneo {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_torneo")
	private Integer id_torneo;
	
	@Column (name="nombre", length=100, nullable=false)
	private String nombre;
	
	@Column (name="anio",length=30)
	private String anio;
	
	@OneToMany
	private List<Partido> partidos;
}
