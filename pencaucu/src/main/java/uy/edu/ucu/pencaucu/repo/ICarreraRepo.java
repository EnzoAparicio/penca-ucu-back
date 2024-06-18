package uy.edu.ucu.pencaucu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Carrera;

@Repository
public interface ICarreraRepo extends JpaRepository<Carrera, Integer>{

	List<Carrera> findAll();
}
