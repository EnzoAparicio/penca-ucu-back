package uy.edu.ucu.pencaucu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IEquipoPartidoDAO;
import uy.edu.ucu.pencaucu.dto.EquipoPartidoDTO;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.repo.IEquipoPartidoRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class EquipoPartidoDAOImpl implements IEquipoPartidoDAO {

	@Autowired
	IEquipoPartidoRepo iEquipoPartidoRepo;

	@Override
	public EquipoPartidoDTO createEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		EquipoPartido equipoPartido = DozerUtil.GetINSTANCE().getMapper().map(equipoPartidoDTO, EquipoPartido.class);
		return DozerUtil.GetINSTANCE().getMapper().map(iEquipoPartidoRepo.save(equipoPartido), EquipoPartidoDTO.class);
	}

	@Override
	public EquipoPartidoDTO updateEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		EquipoPartido equipoPartido = DozerUtil.GetINSTANCE().getMapper().map(equipoPartidoDTO, EquipoPartido.class);
		return DozerUtil.GetINSTANCE().getMapper().map(iEquipoPartidoRepo.save(equipoPartido), EquipoPartidoDTO.class);
	}

}
