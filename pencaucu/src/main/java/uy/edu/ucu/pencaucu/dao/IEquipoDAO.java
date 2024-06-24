package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.EquipoDTO;

public interface IEquipoDAO {

	/**
	 * Crea una entrada de Equipo en la Base de Datos.
	 * 
	 * @param equipoDTO
	 * @return EquipoDTO guardado.
	 */
	EquipoDTO createEquipo(EquipoDTO equipoDTO);

	/**
	 * Actualiza un Equipo en la Base de Datos segun su Id.
	 * 
	 * @param equipoDTO
	 * @return EquipoDTO actualizado, null si ocurre un error.
	 */
	EquipoDTO updateEquipo(EquipoDTO equipoDTO);

	/**
	 * Elimina un Equipo en la Base de datos segun su Id.
	 * 
	 * Si no se encuentra el Equipo, es ignorado sin errores.
	 * 
	 * @param equipoDTO
	 */
	void deleteEquipo(EquipoDTO equipoDTO);

	/**
	 * Devuelve un Equipo segun su Id en la Base de Datos
	 * 
	 * @param id_equipo
	 * @return EquipoDTO con id_equipo, null si no hay coincidencias.
	 */
	EquipoDTO getEquipo(Integer id_equipo);

	/**
	 * Devuelve todas las entradas de Equipo en la Base de Datos.
	 * 
	 * @return List<EquipoDTO> poblada o List vacía si no hay ningún Equipo.
	 */
	List<EquipoDTO> getAllEquipo();

	/**
	 * Devuelve todas las entradas de Equipo en la Base de datos que coincidan en
	 * atributos.
	 * 
	 * @param EquipoDTO poblado solamente con los atributos por los que se quiera
	 *                  filtrar.
	 * @return List<EquipoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */
	List<EquipoDTO> getAllEquipoByFilter(EquipoDTO equipoDTO);
}
