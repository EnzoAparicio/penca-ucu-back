package uy.edu.ucu.pencaucu.dao;

import java.util.List;

import uy.edu.ucu.pencaucu.dto.TorneoDTO;

public interface ITorneoDAO {

	/**
	 * Crea una entrada de Torneo en la Base de Datos.
	 * 
	 * @param torneoDTO
	 * @return TorneoDTO guardado.
	 */
	TorneoDTO createTorneo(TorneoDTO torneoDTO);

	/**
	 * Actualiza un Torneo en la Base de Datos segun su Id.
	 * 
	 * @param torneoDTO
	 * @return TorneoDTO actualizado, null si ocurre un error.
	 */
	TorneoDTO updateTorneo(TorneoDTO TorneoDTO);

	/**
	 * Elimina un Torneo en la Base de datos segun su Id.
	 * 
	 * Si no se encuentra el Torneo, es ignorado sin errores.
	 * 
	 * @param equipoDTO
	 */
	void deleteTorneo(TorneoDTO torneoDTO);

	/**
	 * Devuelve un Torneo segun su Id en la Base de Datos
	 * 
	 * @param id_torneo
	 * @return TorneoDTO con id_torneo, null si no hay coincidencias.
	 */
	TorneoDTO getTorneo(Integer id_torneo);

	/**
	 * Devuelve todas las entradas de Torneo en la Base de Datos.
	 * 
	 * @return List<TorneoDTO> poblada o List vacía si no hay ningún Torneo.
	 */

	List<TorneoDTO> getAllTorneo();

	/**
	 * Devuelve todas las entradas de Torneo en la Base de datos que coincidan en
	 * atributos.
	 * 
	 * @param TorneoDTO poblado solamente con los atributos por los que se quiera
	 *                  filtrar.
	 * @return List<TorneoDTO> poblada o List vacía si no hay ninguna coincidencia.
	 */

	List<TorneoDTO> getAllTorneoByFilter(TorneoDTO torneoDTO);
}