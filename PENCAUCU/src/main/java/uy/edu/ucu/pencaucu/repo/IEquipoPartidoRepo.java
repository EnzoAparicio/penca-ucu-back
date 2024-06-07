package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.EquipoPartido;

@Repository
public interface IEquipoPartidoRepo extends JpaRepository<EquipoPartido, Integer> {
	
	EquipoPartido save(EquipoPartido equipoPartido);
	
	Optional<EquipoPartido> findById(Integer id_equipo_partido);
	
	void deleteById(Integer id_equipo_partido);
}
