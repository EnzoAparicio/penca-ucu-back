package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.model.Usuario;
import uy.edu.ucu.pencaucu.repo.IUsuarioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;
import uy.edu.ucu.pencaucu.util.HasherUtil;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {

	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	@Override
	public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
		
		// Usar Dozer para mapear DTO a entidad
	    Usuario usuario = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
	    
	    usuario.setContrasenia(
	    		HasherUtil.encode(usuario.getContrasenia())
	    		);
	    		
	    // Guardar el objeto usuario en la base de datos
	    Usuario savedUsuario = iUsuarioRepo.save(usuario);
	    
	    if(savedUsuario.getId_usuario() == null) {
	    	return new UsuarioDTO();
	    } else {
		    // Mapear la entidad guardada de vuelta a DTO
		    return DozerUtil.GetINSTANCE().getMapper().map(savedUsuario, UsuarioDTO.class);
	    }
	}
	
	@Override
	public boolean loginUsuario(UsuarioDTO usuarioDTO) {
		
		// Usar Dozer para mapear DTO a entidad
		UsuarioDTO logger = DozerUtil.GetINSTANCE().getMapper().map
				(iUsuarioRepo.findByEmail(usuarioDTO.getEmail()).get(), UsuarioDTO.class);
	
		// Si no encuentra un mail asociado devuelve falso y un mensaje a consola de usuario no existente.
		if(logger == null) return false;
		
		// Hace la verificacion de hashing entre la contraseña provista y la ingresada a la hora del registro.
		return HasherUtil.verify(usuarioDTO.getContrasenia(), logger.getContrasenia());
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuarioBD = iUsuarioRepo.findById(usuarioDTO.getId_usuario()).get();
		
		if (usuarioBD.getId_usuario() == null) return new UsuarioDTO();
		
		usuarioDTO.setContrasenia(usuarioBD.getContrasenia());
		Usuario usuarioActualizado = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
		
		usuarioActualizado = iUsuarioRepo.save(usuarioActualizado);
		
		if (usuarioActualizado.getId_usuario() == null) {
			return new UsuarioDTO();
		} else {
			return DozerUtil.GetINSTANCE().getMapper().map(usuarioActualizado, UsuarioDTO.class);
		}
	}

	@Override
	public void deleteUsuario(UsuarioDTO usuarioDTO) {
		iUsuarioRepo.deleteById(usuarioDTO.getId_usuario());
	}

	@Override
	public UsuarioDTO getUsuario(Integer id_usuario) {
		Optional<Usuario> usuarioDB = iUsuarioRepo.findById(id_usuario);
		if (usuarioDB.isPresent()) {
			return DozerUtil.GetINSTANCE().getMapper().map(usuarioDB.get(), UsuarioDTO.class);
		} else {
			return new UsuarioDTO();
		}
	}

	@Override
	public List<UsuarioDTO> getAllUsuario() {
		return iUsuarioRepo.findAll().stream()
				.map(user -> DozerUtil.GetINSTANCE().getMapper().map(user, UsuarioDTO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UsuarioDTO> getAllUsuarioByFilter(UsuarioDTO usuarioDTO) {
		Example<Usuario> usuarioExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class));
		
		return iUsuarioRepo.findAll(usuarioExample).stream()
				.map(user -> DozerUtil.GetINSTANCE().getMapper().map(user, UsuarioDTO.class))
				.collect(Collectors.toList());
	}
}