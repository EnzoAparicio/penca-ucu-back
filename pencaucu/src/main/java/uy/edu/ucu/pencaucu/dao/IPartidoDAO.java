package uy.edu.ucu.pencaucu.dao;

import java.util.Date;
import java.util.List;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;

public interface IPartidoDAO {

    /**
     * Crea un nuevo partido.
     * 
     * @param partidoDTO - Datos del partido a crear.
     * @return PartidoDTO creado.
     */
    PartidoDTO createPartido(PartidoDTO partidoDTO);

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO - Datos del partido a actualizar.
     * @return PartidoDTO actualizado.
     */
    PartidoDTO updatePartido(PartidoDTO partidoDTO);

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO - Datos del partido a eliminar.
     */
    void deletePartido(PartidoDTO partidoDTO);

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido - Identificador del partido.
     * @return PartidoDTO que coincida o null si no existe.
     */
    PartidoDTO getPartido(Integer id_partido);

    /**
     * Obtiene todos los partidos.
     * 
     * @return Lista de PartidoDTO.
     */
    List<PartidoDTO> getAllPartido();

    /**
     * Obtiene todos los partidos filtrados por los datos proporcionados.
     * 
     * @param partidoDTO - Filtros de búsqueda opcionales.
     * @return Lista de PartidoDTO.
     */
    List<PartidoDTO> getAllPartidoByFilter(PartidoDTO partidoDTO);

    /**
     * Obtiene todos los partidos ya finalizados de un torneo en la fecha ingresada.
     * 
     * @param date - fecha de comparacion.
     * @param torneoDTO - torneo a buscar.
     * @return Lista de partidos que coincidan.
     */
    List<PartidoDTO> getAllFinishedPartido(Date date, Integer idTorneo);
    
    /**
     * Obtiene todos los partidos aun no finalizados de un torneo en la fecha ingresada.
     * 
     * @param date - fecha de comparacion.
     * @param torneoDTO - torneo a buscar.
     * @return Lista de partidos que coincidan.
     */
    List<PartidoDTO> getAllFuturePartido(Date date, Integer idTorneo);
}
