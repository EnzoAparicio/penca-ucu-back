package uy.edu.ucu.pencaucu.service;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.PartidoDTO;

public interface IPartidoService {

	PartidoDTO createPartido(PartidoDTO partidoDTO);
	
	PartidoDTO updatePartido(PartidoDTO partidoDTO);
	
	void deletePartido(PartidoDTO partidoDTO);
	
	PartidoDTO getPartido(Integer id_partido);
	
	List<PartidoDTO> getAllPartido(PartidoDTO partidoDTO);
}
