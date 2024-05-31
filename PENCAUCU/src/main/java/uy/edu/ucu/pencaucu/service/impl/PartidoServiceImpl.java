package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IPartidoDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.service.IPartidoService;

@Service
public class PartidoServiceImpl implements IPartidoService {

	@Autowired
	IPartidoDAO iPartidoDAO;
	
	@Override
	public PartidoDTO createPartido(PartidoDTO partidoDTO) {
		return iPartidoDAO.createPartido(partidoDTO);
	}

	@Override
	public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
		return iPartidoDAO.updatePartido(partidoDTO);
	}

	@Override
	public void deletePartido(PartidoDTO partidoDTO) {
		iPartidoDAO.deletePartido(partidoDTO);
	}

	@Override
	public PartidoDTO getPartido(Integer id_partido) {
		return iPartidoDAO.getPartido(id_partido);
	}

	@Override
	public List<PartidoDTO> getAllPartido(PartidoDTO partidoDTO) {
		if (partidoDTO == null) {
			return iPartidoDAO.getAllPartido();
		} else {
			return iPartidoDAO.getAllPartidoByFilter(partidoDTO);
		}
	}

}