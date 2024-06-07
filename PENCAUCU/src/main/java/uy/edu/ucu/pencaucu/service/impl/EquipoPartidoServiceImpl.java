package uy.edu.ucu.pencaucu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IEquipoPartidoDAO;
import uy.edu.ucu.pencaucu.dto.EquipoPartidoDTO;
import uy.edu.ucu.pencaucu.service.IEquipoPartidoService;


@Service
public class EquipoPartidoServiceImpl implements IEquipoPartidoService {

	@Autowired
	IEquipoPartidoDAO iEquipoPartidoDAO;
	
	@Override
	public EquipoPartidoDTO createEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		return iEquipoPartidoDAO.createEquipoPartido(equipoPartidoDTO);
	}

	@Override
	public EquipoPartidoDTO updateEquipoPartido(EquipoPartidoDTO equipoPartidoDTO) {
		return iEquipoPartidoDAO.updateEquipoPartido(equipoPartidoDTO);
	}	
}