package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.EquipoDTO;

public interface IEquipoDAO {
	
	EquipoDTO createEquipo(EquipoDTO equipoDTO);
	
	EquipoDTO updateEquipo(EquipoDTO equipoDTO);
	
	void deleteEquipo(EquipoDTO equipoDTO);
	
	EquipoDTO getEquipo(Integer id_equipo);
	
	List<EquipoDTO> getAllEquipo();
	
	List<EquipoDTO> getAllEquipoByFilter(EquipoDTO equipoDTO);
}
