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
	    
	    System.out.println(HasherUtil.getSHA256Hash(usuario.getContrasenia()));
	    
	    // Guardar el objeto usuario en la base de datos
	    Usuario savedUsuario = iUsuarioRepo.save(usuario);

	    // Mapear la entidad guardada de vuelta a DTO
	    return DozerUtil.GetINSTANCE().getMapper().map(savedUsuario, UsuarioDTO.class);		
	}
	
	@Override
	public UsuarioDTO loginUsuario(String email, String password) {
		UsuarioDTO logger = new UsuarioDTO();
		logger = DozerUtil.GetINSTANCE().getMapper().map(iUsuarioRepo.findByEmail(email).get(), UsuarioDTO.class);
		return logger;
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		try {
			Usuario usuarioBD = iUsuarioRepo.findById(usuarioDTO.getId_usuario()).get();
			usuarioDTO.setContrasenia(usuarioBD.getContrasenia());
			Usuario usuarioActualizado = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
			
			return DozerUtil.GetINSTANCE().getMapper().map(iUsuarioRepo.save(usuarioActualizado), UsuarioDTO.class);
		} catch (Error e) {
			return null;
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
			return null;
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
