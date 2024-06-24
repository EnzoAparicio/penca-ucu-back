package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IEstadioDAO;
import uy.edu.ucu.pencaucu.dto.EstadioDTO;
import uy.edu.ucu.pencaucu.repo.IEstadioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class EstadioDAOImpl implements IEstadioDAO {

	@Autowired
	IEstadioRepo iEstadioRepo;

	@Override
	public List<EstadioDTO> getAllEstadio() {
		return iEstadioRepo.findAll().stream()
				.map(estadio -> DozerUtil.GetINSTANCE().getMapper().map(estadio, EstadioDTO.class)).toList();
	}

}
