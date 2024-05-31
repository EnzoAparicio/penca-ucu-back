package uy.edu.ucu.pencaucu.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        return DozerUtil.GetINSTANCE().getMapper().map(savedPartido, PartidoDTO.class);        
    }

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO - Datos del partido a actualizar.
     * @return PartidoDTO actualizado.
     */
    @Override
    public PartidoDTO updatePartido(PartidoDTO partidoDTO) {
        Partido partidoBD = iPartidoRepo.findById(partidoDTO.getId_partido()).orElse(null);
        if (partidoBD != null) {
            Partido partidoActualizado = DozerUtil.GetINSTANCE().getMapper().map(partidoDTO, Partido.class);
            return DozerUtil.GetINSTANCE().getMapper().map(iPartidoRepo.save(partidoActualizado), PartidoDTO.class);
        }
        return null;
    }

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO - Datos del partido a eliminar.
     */
    @Override
    public void deletePartido(PartidoDTO partidoDTO) {
        iPartidoRepo.deleteById(partidoDTO.getId_partido());
    }

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido - Identificador del partido.
     * @return PartidoDTO que coincida o null si no existe.
     */
    @Override
    public PartidoDTO getPartido(Integer id_partido) {
        return DozerUtil.GetINSTANCE().getMapper().map(iPartidoRepo.findById(id_partido).orElse(null), PartidoDTO.class);
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
}
