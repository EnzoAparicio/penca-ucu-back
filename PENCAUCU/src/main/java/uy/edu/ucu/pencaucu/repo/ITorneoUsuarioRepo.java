package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Torneo;
import uy.edu.ucu.pencaucu.model.TorneoUsuario;
import uy.edu.ucu.pencaucu.model.Usuario;

@Repository
public interface ITorneoUsuarioRepo extends JpaRepository<TorneoUsuario, Integer>{

	Optional<TorneoUsuario> findByTorneoAndUsuario(Torneo torneo, Usuario usuario);
	
	@SuppressWarnings("unchecked")
	TorneoUsuario save(TorneoUsuario torneoUsuario);
}
