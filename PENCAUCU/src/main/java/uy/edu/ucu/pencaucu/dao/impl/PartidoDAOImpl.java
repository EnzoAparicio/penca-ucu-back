package uy.edu.ucu.pencaucu.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import uy.edu.ucu.pencaucu.dao.IPartidoDAO;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.dto.TorneoDTO;
import uy.edu.ucu.pencaucu.model.EquipoPartido;
import uy.edu.ucu.pencaucu.model.Partido;
import uy.edu.ucu.pencaucu.repo.IEquipoPartidoRepo;
import uy.edu.ucu.pencaucu.repo.IPartidoRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Repository
public class PartidoDAOImpl implements IPartidoDAO {

    @Autowired
    private IPartidoRepo iPartidoRepo;
    
    @Autowired
    private IEquipoPartidoRepo iEquipoPartidoRepo;

    /**
     * Crea un nuevo partido.
     * 
     * @param partidoDTO - Datos del partido a crear.
     * @return PartidoDTO creado.
     */
    @Override
    public PartidoDTO createPartido(PartidoDTO partidoDTO) {
        Partido partido = DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class);
        Partido savedPartido = iPartidoRepo.save(partido);
        
        if (savedPartido.getIdPartido() == null) {
        	return new PartidoDTO();
        } else {
        	for (EquipoPartido equipoPartido : partidoDTO.getEquipos()) {
        		equipoPartido.setPartido(savedPartido);
        		iEquipoPartidoRepo.save(equipoPartido);
        	}
        	
        	
        	return DozerUtil.GetINSTANCE().getMapper().map(savedPartido, PartidoDTO.class);
        }
    }

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO - Datos del partido a actualizar.
     * @return PartidoDTO actualizado.
     */
    @Override
    public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
        Partido partidoBD = iPartidoRepo.findById(partidoDTO.getIdPartido()).orElse(null);
        if (partidoBD == null) return new PartidoDTO();
        
        Partido partido = DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class);
        partido = iPartidoRepo.save(partido);
        if (partido.getIdPartido() == null) {
        	return new PartidoDTO();
        } else {
        	return DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class);
        }
    }

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO - Datos del partido a eliminar.
     */
    @Override
    public void deletePartido(PartidoDTO partidoDTO) {
        iPartidoRepo.deleteById(partidoDTO.getIdPartido());
    }

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido - Identificador del partido.
     * @return PartidoDTO que coincida o null si no existe.
     */
    @Override
    public PartidoDTO getPartido(Integer id_partido) {
    	Optional<Partido> partido = iPartidoRepo.findById(id_partido);
    	if (partido.isPresent()) {
    		return DozerUtil.GetINSTANCE().getMapper().map(partido.get(), PartidoDTO.class);
    	} else {
    		return new PartidoDTO();
    	}
    }

    /**
     * Obtiene todos los partidos.
     * 
     * @return Lista de PartidoDTO.
     */
    @Override
    public List<PartidoDTO> getAllPartido() {
        return iPartidoRepo.findAll().stream()
                .map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los partidos filtrados por los datos proporcionados.
     * 
     * @param partidoDTO - Filtros de búsqueda opcionales.
     * @return Lista de PartidoDTO.
     */
    @Override
    public List<PartidoDTO> getAllPartidoByFilter(PartidoDTO partidoDTO) {
        Example<Partido> partidoExample = Example.of(DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class));
        return iPartidoRepo.findAll(partidoExample).stream()
                .map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
    }

    
	@Override
	public List<PartidoDTO> getAllFinishedPartido(Date date, TorneoDTO torneoDTO) {
		return iPartidoRepo.findByIdTorneoAndFechaLessThan(torneoDTO.getIdTorneo(), date).stream()
                .map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
	}

	@Override
	public List<PartidoDTO> getAllFuturePartido(Date date, TorneoDTO torneoDTO) {
		return iPartidoRepo.findByIdTorneoAndFechaGreaterThan(torneoDTO.getIdTorneo(), date).stream()
                .map(partido -> DozerUtil.GetINSTANCE().getMapper().map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
	}
}
