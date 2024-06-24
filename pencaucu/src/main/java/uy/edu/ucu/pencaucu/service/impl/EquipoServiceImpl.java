package uy.edu.ucu.pencaucu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dao.IEquipoDAO;
import uy.edu.ucu.pencaucu.dto.EquipoDTO;
import uy.edu.ucu.pencaucu.service.IEquipoService;

@Service
public class EquipoServiceImpl implements IEquipoService {

	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public EquipoDTO createEquipo(EquipoDTO equipoDTO) {
		try {
			if (equipoDTO.getNombre() == null || equipoDTO.getColor() == null) {
				throw new Exception("Campos faltantes para creacion.");
			}
			return iEquipoDAO.createEquipo(equipoDTO);
		} catch (Exception camposFaltantes) {
			return null;
		}
	}

	@Override
	public EquipoDTO updateEquipo(EquipoDTO equipoDTO) {
		try {
			if (equipoDTO.getNombre() == null || equipoDTO.getColor() == null || equipoDTO.getIdEquipo() == null) {
				throw new Exception("Campos faltantes para actualizacion.");
			}
			return iEquipoDAO.updateEquipo(equipoDTO);
		} catch (Exception camposFaltantes) {
			return null;
		}
	}

	@Override
	public void deleteEquipo(EquipoDTO equipoDTO) {
		iEquipoDAO.deleteEquipo(equipoDTO);

	}

	@Override
	public EquipoDTO getEquipo(Integer id_equipo) {
		return iEquipoDAO.getEquipo(id_equipo);
	}

	@Override
	public List<EquipoDTO> getAllEquipo(EquipoDTO equipoDTO) {
		if (equipoDTO == null) {
			return iEquipoDAO.getAllEquipo();
		} else {
			return iEquipoDAO.getAllEquipoByFilter(equipoDTO);
		}
	}

}
