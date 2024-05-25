package uy.edu.ucu.pencaucu.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;

@Data
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id_usuario")
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id_usuario;

	@Column(name = "nombre", length=50, nullable=false)
	private String nombre;

	@Column(name = "apellido", length=50, nullable=false)
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
