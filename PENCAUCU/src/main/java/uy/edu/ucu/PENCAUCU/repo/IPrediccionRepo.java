package uy.edu.ucu.PENCAUCU.repo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy.edu.ucu.PENCAUCU.model.Prediccion;

@Repository
public interface IPrediccionRepo extends JpaRepository<Prediccion, Integer>{
    Optional<Prediccion> findById(Integer id);
}