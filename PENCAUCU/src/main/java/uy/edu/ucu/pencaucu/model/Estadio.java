package uy.edu.ucu.pencaucu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "estadio")
@Entity
public class Estadio {
	
	/*
     * Identificador único del estadio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio")
    private Integer id_estadio;

    /**
     * Nombre del estadio.
     */
    @Column(name="nombre", length=50, nullable=false, unique=true)
    private String nombre;
}

