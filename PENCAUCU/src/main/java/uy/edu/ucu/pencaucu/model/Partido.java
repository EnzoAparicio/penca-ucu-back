package uy.edu.ucu.pencaucu.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Table(name = "partido")
@Entity
public class Partido {

    /**
     * Identificador único del partido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Integer id_partido;

    /**
     * Resultado del equipo 1 en el partido.
     */
    @Column(name = "resultado_e1")
    private Integer resultado_e1;

    /**
     * Resultado del equipo 2 en el partido.
     */
    @Column(name = "resultado_e2")
    private Integer resultado_e2;

    /**
     * Fecha del partido.
     */
    @Column(name = "fecha")
    private Date fecha;

    /**
     * Estadio donde se juega el partido.
     */
    @ManyToOne
    @JoinColumn(name = "id_estadio", nullable = false)
    private Estadio estadio;

    @OneToMany(mappedBy = "partido")
    private List<EquipoPartido> equipos;
    
    /**
     * Torneo al que pertenece el partido.
     */
    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;
}
