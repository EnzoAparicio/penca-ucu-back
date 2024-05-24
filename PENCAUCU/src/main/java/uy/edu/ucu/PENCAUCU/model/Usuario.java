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
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	public int idUsuario;
	
	@Column(name = "nomrbe")
	public String nombre;
	
	@Column(name = "apellido")
	public String apellido;
	
	@Column(name = "avatarPath")
	public String avatarPath;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "carrera")
	public Carrera carrera;
	
	@Column(name = "puntos")
	public int puntos;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "contrasenia")
	public String contrasenia;
}
