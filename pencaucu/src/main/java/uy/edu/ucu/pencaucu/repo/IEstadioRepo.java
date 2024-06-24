package uy.edu.ucu.pencaucu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Estadio;

@Repository
public interface IEstadioRepo extends JpaRepository<Estadio, Integer> {

	List<Estadio> findAll();
}
