package uy.edu.ucu.pencaucu.repo;	

import java.util.Optional;	

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;	

import uy.edu.ucu.pencaucu.model.Prediccion;	

@Repository	
public interface IPrediccionRepo extends JpaRepository<Prediccion, Integer>{	

    Optional<Prediccion> findById(Integer id_prediccion);	

    void deleteById (Integer id_prediccion);	

}
