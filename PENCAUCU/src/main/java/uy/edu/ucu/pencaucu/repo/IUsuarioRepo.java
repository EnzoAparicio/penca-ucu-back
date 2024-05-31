package uy.edu.ucu.pencaucu.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	Usuario save(Usuario usuario);
	
	Optional<Usuario> findById(Integer id_usuario);
	
	Optional<Usuario> findByEmail(String email);
	
	void deleteById(Integer id_usuario);
}
