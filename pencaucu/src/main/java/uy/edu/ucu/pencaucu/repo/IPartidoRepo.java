package uy.edu.ucu.pencaucu.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Partido;

@Repository
public interface IPartidoRepo extends JpaRepository<Partido, Integer> {

	@SuppressWarnings("unchecked")
	Partido save(Partido partido);

	Optional<Partido> findById(Integer id_partido);

	List<Partido> findByIdTorneoAndFechaLessThan(Integer id_torneo, Date fecha);

	List<Partido> findByIdTorneoAndFechaGreaterThan(Integer id_torneo, Date fecha);
}
