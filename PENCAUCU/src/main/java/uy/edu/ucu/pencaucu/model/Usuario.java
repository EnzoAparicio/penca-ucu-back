package uy.edu.ucu.pencaucu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "usuario")
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id_usuario;

	@Column(name = "nombre", length=50, nullable=false)
	private String nombre;

	@Column(name = "apellido", length=50)
	private String apellido;

	@Column(name = "avatar_path", length=50)
	private String avatar_path;

	//@Enumerated(EnumType.STRING)
	//@Column (name = "carrera")
	//private Carrera carrera;

	@Column(name = "puntos")
	private Integer puntos;

	@Column(name = "email", length=50, nullable=false)
	private String email;

	@Column(name = "contrasenia", length=50, nullable=false)
	private String contrasenia;
}
