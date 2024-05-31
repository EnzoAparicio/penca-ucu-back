package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import org.springframework.data.domain.ExampleMatcher;

import uy.edu.ucu.pencaucu.dto.PartidoDTO;

public interface IPartidoDAO {

	PartidoDTO createPartido(PartidoDTO PartidoDTO);
	
	PartidoDTO updatePartido(PartidoDTO PartidoDTO);
	
	void deletePartido(PartidoDTO PartidoDTO);
	
	PartidoDTO getPartido(Integer id_partido);
	
	List<PartidoDTO> getAllPartido();
	
	List<PartidoDTO> getAllPartidoByFilter(PartidoDTO PartidoDTO);
}
