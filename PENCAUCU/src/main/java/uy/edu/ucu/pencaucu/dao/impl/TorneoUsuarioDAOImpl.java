package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.ITorneoUsuarioDAO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.dto.TorneoUsuarioDTO;
import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.model.Torneo;
import uy.edu.ucu.pencaucu.model.TorneoUsuario;
import uy.edu.ucu.pencaucu.model.Usuario;
import uy.edu.ucu.pencaucu.repo.ITorneoUsuarioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class TorneoUsuarioDAOImpl implements ITorneoUsuarioDAO {

	@Autowired
	ITorneoUsuarioRepo iTorneoUsuarioRepo;
	
	@Override
	public TorneoUsuarioDTO updateTorneoUsuario(TorneoUsuarioDTO torneoUsuarioDTO) {
		TorneoUsuario torneoUsuario = DozerUtil.GetINSTANCE().getMapper().map(torneoUsuarioDTO, TorneoUsuario.class);
		return DozerUtil.GetINSTANCE().getMapper().map(iTorneoUsuarioRepo.save(torneoUsuario), TorneoUsuarioDTO.class);
	}

	@Override
	public TorneoUsuarioDTO getByTorneoAndUsuario(TorneoDTO torneoDTO, UsuarioDTO usuarioDTO) {
		Torneo torneo = DozerUtil.GetINSTANCE().getMapper().map(torneoDTO, Torneo.class);
		Usuario usuario = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
		Optional<TorneoUsuario> torneoUsuario = iTorneoUsuarioRepo.findByTorneoAndUsuario(torneo, usuario);
		if (torneoUsuario.isPresent()) {
			return DozerUtil.GetINSTANCE().getMapper().map(torneoUsuario.get(), TorneoUsuarioDTO.class);
		} else {
			return new TorneoUsuarioDTO();
		}
	}

	@Override
	public List<TorneoUsuarioDTO> getAllByTorneo(Integer id_torneo) {
		Torneo torneo = new Torneo();
		torneo.setIdTorneo(id_torneo);
		return iTorneoUsuarioRepo.findAllByTorneo(torneo).stream()
				.map(torneoUsuario -> DozerUtil.GetINSTANCE().getMapper().map(torneoUsuario, TorneoUsuarioDTO.class))
				.toList();
	}

}
