package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.ICarreraDAO;
import uy.edu.ucu.pencaucu.dto.CarreraDTO;
import uy.edu.ucu.pencaucu.repo.ICarreraRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class CarreraDAOImpl implements ICarreraDAO {

	@Autowired
	ICarreraRepo iCarreraRepo;

	@Override
	public List<CarreraDTO> getAllCarrera() {
		return iCarreraRepo.findAll().stream()
				.map(carrera -> DozerUtil.GetINSTANCE().getMapper().map(carrera, CarreraDTO.class)).toList();
	}

}
