package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Torneo;


@Repository
public interface ITorneoRepo extends JpaRepository<Torneo, Integer> {
	
	@SuppressWarnings("unchecked")
	Torneo save(Torneo torneo);
	
	Optional<Torneo> findById(Integer id_torneo);

	void deleteById(Integer id_torneo);
}
