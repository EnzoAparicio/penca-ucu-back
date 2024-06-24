package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.ITorneoDAO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.model.Torneo;
import uy.edu.ucu.pencaucu.repo.ITorneoRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class TorneoDAOImpl implements ITorneoDAO {

	@Autowired
	ITorneoRepo iTorneoRepo;

	@Override
	public TorneoDTO createTorneo(TorneoDTO torneoDTO) {
		Torneo torneo = DozerUtil.GetINSTANCE().getMapper().map(torneoDTO, Torneo.class);
		return DozerUtil.GetINSTANCE().getMapper().map(iTorneoRepo.save(torneo), TorneoDTO.class);

	}

	@Override
	public TorneoDTO updateTorneo(TorneoDTO torneoDTO) {
		try {
			Torneo torneoActualizado = DozerUtil.GetINSTANCE().getMapper().map(torneoDTO, Torneo.class);

			return DozerUtil.GetINSTANCE().getMapper().map(iTorneoRepo.save(torneoActualizado), TorneoDTO.class);
		} catch (Error e) {
			return null;
		}
	}

	@Override
	public void deleteTorneo(TorneoDTO torneoDTO) {
		iTorneoRepo.deleteById(torneoDTO.getIdTorneo());

	}

	@Override
	public TorneoDTO getTorneo(Integer id_torneo) {
		Optional<Torneo> torneoDB = iTorneoRepo.findById(id_torneo);
		if (torneoDB.isPresent()) {
			return DozerUtil.GetINSTANCE().getMapper().map(torneoDB.get(), TorneoDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public List<TorneoDTO> getAllTorneo() {
		return iTorneoRepo.findAll().stream()
				.map(torneo -> DozerUtil.GetINSTANCE().getMapper().map(torneo, TorneoDTO.class))
				.collect(Collectors.toList());

	}

	@Override
	public List<TorneoDTO> getAllTorneoByFilter(TorneoDTO torneoDTO) {
		Example<Torneo> torneoExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(torneoDTO, Torneo.class));

		return iTorneoRepo.findAll(torneoExample).stream()
				.map(torneo -> DozerUtil.GetINSTANCE().getMapper().map(torneo, TorneoDTO.class))
				.collect(Collectors.toList());
	}

}
