package uy.edu.ucu.pencaucu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IEquipoPartidoDAO;
import uy.edu.ucu.pencaucu.dto.EquipoPartidoDTO;
import uy.edu.ucu.pencaucu.repo.IEquipoPartidoRepo;




@Repository
public class EquipoPartidoDAOImpl implements IEquipoPartidoDAO {

	@Autowired
	IEquipoPartidoRepo IEquipoTorneoRepo;
	
	@Override
	public EquipoPartidoDTO createEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		return new EquipoPartidoDTO();
	}

	@Override
	public EquipoPartidoDTO updateEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		return new EquipoPartidoDTO();
	}
	
}
