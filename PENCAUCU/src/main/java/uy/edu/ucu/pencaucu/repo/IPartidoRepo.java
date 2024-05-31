package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Partido;

@Repository
public interface IPartidoRepo extends JpaRepository<Partido, Integer>{

	Optional<Partido> findById(Integer id_partido);
}