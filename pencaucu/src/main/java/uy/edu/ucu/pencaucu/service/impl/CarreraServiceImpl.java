package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.ICarreraDAO;
import uy.edu.ucu.pencaucu.dto.CarreraDTO;
import uy.edu.ucu.pencaucu.service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	ICarreraDAO iCarreraDAO;
	
	@Override
	public List<CarreraDTO> getAllCarrera() {
		return iCarreraDAO.getAllCarrera();
	}

}
