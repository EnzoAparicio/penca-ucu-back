package uy.edu.ucu.PENCAUCU.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "prediccion")
@PrimaryKeyJoinColumn(name = "id_prediccion")
public class Prediccion {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prediccion")
	public int idPrediccion;

    @Column(name = "prediccion_e1")
	public int prediccion_e1;

    @Column(name = "prediccion_e2")
    public int prediccion_e2;

    @Column(name="ganador")
    public String ganador;

}
