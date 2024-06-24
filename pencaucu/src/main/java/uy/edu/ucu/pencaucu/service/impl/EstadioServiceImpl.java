package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IEstadioDAO;
import uy.edu.ucu.pencaucu.dto.EstadioDTO;
import uy.edu.ucu.pencaucu.service.IEstadioService;

@Service
public class EstadioServiceImpl implements IEstadioService {

	@Autowired
	IEstadioDAO iEstadioDAO;

	@Override
	public List<EstadioDTO> getAllEstadio() {
		return iEstadioDAO.getAllEstadio();
	}

}
