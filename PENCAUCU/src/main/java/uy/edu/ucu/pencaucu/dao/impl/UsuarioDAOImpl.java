package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.model.Usuario;
import uy.edu.ucu.pencaucu.repo.IUsuarioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {

	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	@Override
	public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
		// Usar Dozer para mapear DTO a entidad
	    Usuario usuario = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
	    
	    // Guardar el objeto usuario en la base de datos
	    Usuario savedUsuario = iUsuarioRepo.save(usuario);

	    // Mapear la entidad guardada de vuelta a DTO
	    return DozerUtil.GetINSTANCE().getMapper().map(savedUsuario, UsuarioDTO.class);		
	}

	@Override
	public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUsuario(UsuarioDTO usuarioDTO) {
		iUsuarioRepo.deleteById(usuarioDTO.getId_usuario());
	}

	@Override
	public UsuarioDTO getUsuario(Integer id_usuario) {
		return DozerUtil.GetINSTANCE().getMapper().map(iUsuarioRepo.findById(id_usuario).get(), UsuarioDTO.class);
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
