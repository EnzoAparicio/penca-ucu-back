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

    @Column(name = "prediccion_e1")	
	private Integer prediccion_e1;	

    @Column(name = "prediccion_e2")	
    private Integer prediccion_e2;	

    @Column(name="ganador", length=50)	
    private String ganador;	

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
