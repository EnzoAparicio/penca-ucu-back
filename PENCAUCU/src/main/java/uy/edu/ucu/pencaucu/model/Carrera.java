package uy.edu.ucu.pencaucu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Carrera {
	
	@Id
	@Column(name="id_carrera")
	private Integer id_carrera;
	
	@Column(name="nombre", length=50, nullable=false, unique=true)
	private String nombre;
	
	@Column(name="anios", length=30)
	private String anios;
	
}
