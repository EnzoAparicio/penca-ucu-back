package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IEquipoDAO;
import uy.edu.ucu.pencaucu.dto.EquipoDTO;
import uy.edu.ucu.pencaucu.model.Equipo;
import uy.edu.ucu.pencaucu.repo.IEquipoRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class EquipoDAOImpl implements IEquipoDAO {

	@Autowired
	IEquipoRepo iEquipoRepo;

	@Override
	public EquipoDTO createEquipo(EquipoDTO equipoDTO) {
		Equipo equipo = DozerUtil.GetINSTANCE().getMapper().map(equipoDTO, Equipo.class);

		return DozerUtil.GetINSTANCE().getMapper().map(iEquipoRepo.save(equipo), EquipoDTO.class);
	}

	@Override
	public EquipoDTO updateEquipo(EquipoDTO equipoDTO) {
		try {
			Equipo equipoActualizado = DozerUtil.GetINSTANCE().getMapper().map(equipoDTO, Equipo.class);

			return DozerUtil.GetINSTANCE().getMapper().map(iEquipoRepo.save(equipoActualizado), EquipoDTO.class);
		} catch (Error e) {
			return null;
		}
	}

	@Override
	public void deleteEquipo(EquipoDTO equipoDTO) {
		iEquipoRepo.deleteById(equipoDTO.getIdEquipo());

	}

	@Override
	public EquipoDTO getEquipo(Integer id_equipo) {
		Optional<Equipo> equipoDB = iEquipoRepo.findById(id_equipo);
		if (equipoDB.isPresent()) {
			return DozerUtil.GetINSTANCE().getMapper().map(equipoDB.get(), EquipoDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public List<EquipoDTO> getAllEquipo() {
		return iEquipoRepo.findAll().stream()
				.map(equipo -> DozerUtil.GetINSTANCE().getMapper().map(equipo, EquipoDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EquipoDTO> getAllEquipoByFilter(EquipoDTO equipoDTO) {
		Example<Equipo> equipoExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(equipoDTO, Equipo.class));

		return iEquipoRepo.findAll(equipoExample).stream()
				.map(equipo -> DozerUtil.GetINSTANCE().getMapper().map(equipo, EquipoDTO.class))
				.collect(Collectors.toList());
	}

}
