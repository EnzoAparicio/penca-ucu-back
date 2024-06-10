package uy.edu.ucu.pencaucu.repo;	

import java.util.Optional;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Partido;
import uy.edu.ucu.pencaucu.model.Prediccion;
import java.util.List;
	

@Repository	
public interface IPrediccionRepo extends JpaRepository<Prediccion, Integer>{	

    Optional<Prediccion> findById(Integer id_prediccion);	
    
    List<Prediccion> findAllByPartido(Partido partido);

}
