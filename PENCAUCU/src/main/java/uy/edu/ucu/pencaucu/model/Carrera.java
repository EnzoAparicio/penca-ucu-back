package uy.edu.ucu.pencaucu.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Carrera {
	
	private String nombre;
	
	private int anios;
	
}
