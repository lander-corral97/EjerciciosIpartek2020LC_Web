package com.ipartek.formacion.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Perro;

/**
 * DAO para definir las operaciones de CRUD
 * 
 * @author LANDER
 *
 */

public interface PerroDAO {

	/**
	 * @return todos los perros, si no existe ninguno, retorna un array vac�o
	 */
	ArrayList<Perro> listar();

	/**
	 * Recupera el detalle de un Perro
	 * 
	 * @param id Identificador
	 * @return Perro con sus datos o null si no encuentra
	 */
	Perro recuperar(int id);

	/**
	 * Crea un nuevo perro y cuando es guardado se le asigna una nueva id
	 * 
	 * @throws Exception si el nombre del perro ya existe
	 * @param p Perro con los datos a guardar
	 * @return Perro con su id actualizado
	 */
	Perro crear(Perro p) throws Exception;

	/**
	 * Modifica un perro
	 * 
	 * @param p Perro con los datos nuevos
	 * @return Perro modificado
	 * @throws Exception Si no encuentra el perro, o el nombre ya existe
	 */
	Perro modificar(Perro p) throws Exception;

	/**
	 * Elimina el Perro gracias a su id
	 * 
	 * @param id Identificador
	 * @throws Exception
	 * @return true si elimina, false en caso contrario
	 */
	boolean eliminar(int id) throws Exception;

}
