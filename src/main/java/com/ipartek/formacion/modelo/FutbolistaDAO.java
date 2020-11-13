package com.ipartek.formacion.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Futbolista;

/**
 * DAO para los Futbolistas
 * 
 * @author LANDER
 * @version 1.0
 */
public interface FutbolistaDAO extends DAO<Futbolista> {

	/**
	 * Se introduce un par�metro de b�squeda para sacar un array con los datos que
	 * coincidan
	 * 
	 * @param busqueda Parte del nombre para buscar en el array
	 * @return ArrayList con todos los futbolistas que contengan el par�metro
	 *         {@code busqueda}
	 * @throws Exception Si hay un problema con la BBDD
	 */
	ArrayList<Futbolista> buscarFutbolistaPorNombre(String busqueda) throws Exception;

	/**
	 * Devuelve una lista con dicha nacionalidad
	 * 
	 * @param nacionalidad Nacionalidad a buscar
	 * @return ArrayList con todos los futbolistas de dicha nacionalidad
	 * @throws Exception Si hay un problema con la BBDD
	 */
	ArrayList<Futbolista> getFutbolistaNacionalidad(String nacionalidad) throws Exception;

	/**
	 * Devuelve una lista que se mayor/menor de edad X
	 * 
	 * @param edad       Edad para comparar
	 * @param mayorMenor String para saber si comparar como mayor o menor
	 * @return ArrayList con Futbolistas mayor o menor de dicha edad
	 * @throws Exception No encuentra futbolistas
	 */
	ArrayList<Futbolista> getFutbolistaMayorMenorEdad(int edad, String mayorMenor) throws Exception;

}
