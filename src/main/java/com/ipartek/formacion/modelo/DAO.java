package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface DAO<P> {

	/**
	 * Lista de ???
	 * 
	 * @return Array con los ???
	 * @throws Exception ???
	 */
	ArrayList<P> listar() throws Exception;

	/**
	 * Devuelve el ??? con dicho id
	 * 
	 * @param id Identificador
	 * @return ??? cuyo id es {@code id} o null
	 * @throws Exception Si hay un problema con la BBDD
	 */
	P get(int id) throws Exception;

	/**
	 * Crea un nuevo ??? y los mete en el array
	 * 
	 * @param p ??? a introducir en la lista
	 * @return ??? introducido
	 * @throws Exception Si el ??? ya est� en el array
	 */
	P nuevo(P p) throws Exception;

	/**
	 * Introduce los nuevos datos del ??? y los reemplaza por los nuevos
	 * 
	 * @param p ??? a modificar
	 * @return ??? modificado
	 * @throws Exception Si no encuentra al ??? o no existe.
	 */
	P modificar(P p) throws Exception;

	/**
	 * Borra el ??? con dicho id
	 * 
	 * @param id Identificador
	 * @return true; si borra, false; si no borra
	 * @throws Exception Si hay un problema con la BBDD
	 */
	boolean borrar(int id) throws Exception;
}
