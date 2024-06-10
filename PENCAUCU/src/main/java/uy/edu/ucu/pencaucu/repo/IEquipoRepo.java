package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Equipo;

@Repository
public interface IEquipoRepo extends JpaRepository<Equipo, Integer> {
	
	@SuppressWarnings("unchecked")
	Equipo save(Equipo equipo);
	
	Optional<Equipo> findById(Integer id_equipo);
	
	void deleteById(Integer id_equipo);
}
