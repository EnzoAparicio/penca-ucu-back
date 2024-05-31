package uy.edu.ucu.pencaucu.service;

import java.util.List;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;

public interface IPartidoService {

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
     * Obtiene todos los partidos, opcionalmente filtrados por los datos proporcionados.
     * 
     * @param partidoDTO - Filtros de búsqueda opcionales.
     * @return Lista de PartidoDTO.
     */
    List<PartidoDTO> getAllPartido(PartidoDTO partidoDTO);
}
