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
@Table(name = "prediccion")
@PrimaryKeyJoinColumn(name = "idPrediccion")
public class Prediccion {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPrediccion")
	public int idPrediccion;

    @Column(name = "prediccionE1")
	public int prediccionE1;

    @Column(name = "prediccionE2")
    public int prediccionE2;

    @Column(name="ganador")
    public String ganador;

}
