package uy.edu.ucu.pencaucu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.ucu.pencaucu.dto.PartidoDTO;
import uy.edu.ucu.pencaucu.service.IPartidoService;


@RestController
public class PartidoController {

    @Autowired
    private IPartidoService iPartidoService;

    /**
     * Crea un nuevo partido.
     * 
     * @param partidoDTO Datos del partido a crear.
     * @return Partido creado.
     */
    @PostMapping("/partido/create")
    public PartidoDTO createPartido(@RequestBody PartidoDTO partidoDTO) {
        return iPartidoService.createPartido(partidoDTO);
    }

    /**
     * Actualiza un partido existente.
     * 
     * @param partidoDTO Datos del partido a actualizar.
     * @return Partido actualizado.
     */
    @PutMapping("/partido/update")
    public PartidoDTO updatePartido(@RequestBody PartidoDTO partidoDTO) {
        return iPartidoService.updatePartido(partidoDTO);
    }

    /**
     * Elimina un partido.
     * 
     * @param partidoDTO Datos del partido a eliminar.
     */
    @DeleteMapping("/partido/delete")
    public void deletePartido(@RequestBody PartidoDTO partidoDTO) {
        iPartidoService.deletePartido(partidoDTO);
    }

    /**
     * Obtiene un partido por su identificador.
     * 
     * @param id_partido Identificador del partido.
     * @return Partido encontrado.
     */
    @GetMapping("/partido/{id_partido}")
    public PartidoDTO getPartido(@PathVariable Integer id_partido) {
        return iPartidoService.getPartido(id_partido);
    }

    /**
     * Obtiene todos los partidos, opcionalmente filtrados por los datos proporcionados.
     * 
     * @param partidoDTO Filtros de búsqueda opcionales.
     * @return Lista de partidos.
     */
    @GetMapping("/partido/getAll")
    public List<PartidoDTO> getAllPartido(@RequestBody(required = false) PartidoDTO partidoDTO) {
        return iPartidoService.getAllPartido(partidoDTO);
    }
}
