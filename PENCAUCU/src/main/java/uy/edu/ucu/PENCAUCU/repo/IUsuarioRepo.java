package uy.edu.ucu.PENCAUCU.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uy.edu.ucu.PENCAUCU.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findById(Integer id_usuario);
}
