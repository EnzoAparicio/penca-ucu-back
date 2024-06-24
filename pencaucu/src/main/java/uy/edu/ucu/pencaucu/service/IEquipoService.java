package uy.edu.ucu.pencaucu.service;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.EquipoDTO;

public interface IEquipoService {

	/**
	 * Revisa los campos no null y solicita la creación del Equipo.
	 * 
	 * @param equipoDTO
	 * @return EquipoDTO creado o null si ocurrió un error.
	 */
	EquipoDTO createEquipo(EquipoDTO equipoDTO);

	/**
	 * Revisa los campos no null y solicita la actualización del Equipo según su id.
	 * 
	 * @param equipoDTO
	 * @return EquipoDTO actualizado o null si ocurrió un error.
	 */
	EquipoDTO updateEquipo(EquipoDTO equipoDTO);

	/**
	 * Solicita la eliminacion del Equipo según su Id.
	 * 
	 * Ignora silenciosamente si el id del equipo no existe.
	 * 
	 * @param equipoDTO
	 */
	void deleteEquipo(EquipoDTO equipoDTO);

	/**
	 * Solicita el Equipo por Id.
	 * 
	 * @param id_equipo
	 * @return EquipoDTO que coincida o null si no hay coincidencias.
	 */
	EquipoDTO getEquipo(Integer id_equipo);

	/**
	 * Solicita todos los Equipos que coincidan con el parámetro.
	 * 
	 * @param equipoDTO nullable
	 * @return List<EquipoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	List<EquipoDTO> getAllEquipo(EquipoDTO equipoDTO);
}
