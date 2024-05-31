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
@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private Integer id_equipo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "img_bandera")
	private String img_bandera;
	
	@Column(name = "color")
	private String color;
	
//	@OneToMany
//	private List<Partido> partidos;
}
