package uy.edu.ucu.pencaucu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uy.edu.ucu.pencaucu.model.Torneo;

public interface ITorneoRepo extends JpaRepository<Torneo, Integer> {

}
