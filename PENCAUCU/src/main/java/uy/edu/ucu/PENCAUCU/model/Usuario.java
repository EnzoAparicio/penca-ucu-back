package uy.edu.ucu.PENCAUCU.model;

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
@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id_usuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "avatar_path")
	private String avatar_path;

	//@Enumerated(EnumType.STRING)
	//@Column (name = "carrera")
	//private Carrera carrera;

	@Column(name = "puntos")
	private Integer puntos;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasenia")
	private String contrasenia;
}
