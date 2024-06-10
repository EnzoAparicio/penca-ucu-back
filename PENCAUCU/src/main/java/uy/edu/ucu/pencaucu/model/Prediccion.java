package uy.edu.ucu.pencaucu.model;	

import jakarta.persistence.Column;	
import jakarta.persistence.Entity;	
import jakarta.persistence.GeneratedValue;	
import jakarta.persistence.GenerationType;	
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;	
import jakarta.persistence.Table;	
import lombok.Data;	

@Data	
@Entity	
@Table(name = "prediccion")	
public class Prediccion {	

    @Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_prediccion")	
	private Integer id_prediccion;	

    @Column(name = "prediccion_equipo1")	
	private Integer prediccion_equipo1;	

    @Column(name = "prediccion_equipo2")	
    private Integer prediccion_equipo2;	

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    @Column(name = "id_usuario")
    private Integer id_usuario;
}
