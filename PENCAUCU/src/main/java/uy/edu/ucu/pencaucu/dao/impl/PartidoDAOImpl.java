package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.pencaucu.dao.IPartidoDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.model.Partido;
import uy.edu.ucu.pencaucu.repo.IPartidoRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class PartidoDAOImpl implements IPartidoDAO {

	@Autowired
	private IPartidoRepo iPartidoRepo;
	
	public PartidoDTO createPartido(PartidoDTO partidoDTO) {
		// Usar Dozer para mapear DTO a entidad
	    Partido partido = DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class);
	    
	    // Guardar el objeto partido en la base de datos
	    Partido savedPartido = iPartidoRepo.save(partido);

	    // Mapear la entidad guardada de vuelta a DTO
	    return DozerUtil.GetINSTANCE().getMapper().map(savedPartido, PartidoDTO.class);		
	}

	@Override
	public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
		try {
			Partido partidoBD = iPartidoRepo.findById(partidoDTO.getId_partido()).get();
			Partido partidoActualizado = DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class);
			
			return DozerUtil.GetINSTANCE().getMapper().map(iPartidoRepo.save(partidoActualizado), PartidoDTO.class);
		} catch (Error e) {
			return null;
		}
	}
	

	@Override
	public void deletePartido(PartidoDTO partidoDTO) {
		iPartidoRepo.deleteById(partidoDTO.getId_partido());
		
	}

	@Override
	public PartidoDTO getPartido(Integer id_partido) {
		return DozerUtil.GetINSTANCE().getMapper().map(iPartidoRepo.findById(id_partido).get(), PartidoDTO.class);
	}

	@Override
	public List<PartidoDTO> getAllPartido() {
		return iPartidoRepo.findAll().stream()
				.map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<PartidoDTO> getAllPartidoByFilter(PartidoDTO partidoDTO) {		
		Example<Partido> partidoExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class));
		System.out.println("\n" + partidoExample.toString());
		return iPartidoRepo.findAll(partidoExample).stream()
				.map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
				.collect(Collectors.toList());
	}
}