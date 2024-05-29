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
@Entity
@Table(name = "prediccion")
public class Prediccion {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prediccion")
	private Integer idPrediccion;

    @Column(name = "prediccion_e1")
	private Integer prediccion_e1;

    @Column(name = "prediccion_e2")
    private Integer prediccion_e2;

    @Column(name="ganador", length=50)
    private String ganador;

}
