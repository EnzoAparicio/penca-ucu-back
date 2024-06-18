package uy.edu.ucu.pencaucu.service.impl;

import java.util.Date;
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

    /**
     * Crea un nuevo partido.
     * 
     * @param partidoDTO Datos del partido a crear.
     * @return Partido creado.
     */
    @Override
    public PartidoDTO createPartido(PartidoDTO partidoDTO) {
        return iPartidoDAO.createPartido(partidoDTO);
    }

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO Datos del partido a actualizar.
     * @return Partido actualizado.
     */
    @Override
    public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
        return iPartidoDAO.updatePartido(partidoDTO);
    }

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO Datos del partido a eliminar.
     */
    @Override
    public void deletePartido(PartidoDTO partidoDTO) {
        iPartidoDAO.deletePartido(partidoDTO);
    }

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido Identificador del partido.
     * @return Partido encontrado.
     */
    @Override
    public PartidoDTO getPartido(Integer id_partido) {
        return iPartidoDAO.getPartido(id_partido);
    }

    /**
     * Obtiene todos los partidos.
     * 
     * @param partidoDTO Filtros de búsqueda opcionales.
     * @return Lista de partidos.
     */
    @Override
    public List<PartidoDTO> getAllPartido(PartidoDTO partidoDTO) {
        if (partidoDTO == null) {
            return iPartidoDAO.getAllPartido();
        } else {
            return iPartidoDAO.getAllPartidoByFilter(partidoDTO);
        }
    }

    /**
     * Obtiene todos los partidos ya finalizados de un torneo en la fecha ingresada.
     * 
     * @param date - fecha de comparacion.
     * @param torneoDTO - torneo a buscar.
     * @return Lista de partidos que coincidan.
     */
	@Override
	public List<PartidoDTO> getAllFinishedPartido(Date date, Integer idTorneo) {
		return iPartidoDAO.getAllFinishedPartido(date, idTorneo);
	}

    /**
     * Obtiene todos los partidos aun no finalizados de un torneo en la fecha ingresada.
     * 
     * @param date - fecha de comparacion.
     * @param torneoDTO - torneo a buscar.
     * @return Lista de partidos que coincidan.
     */
	@Override
	public List<PartidoDTO> getAllFuturePartido(Date date, Integer idTorneo) {
		return iPartidoDAO.getAllFuturePartido(date, idTorneo);
	}
}
