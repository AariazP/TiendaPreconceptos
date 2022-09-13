package com.uniquindio.programacionIII.Model;

import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;

public interface CRUDTienda<T> {
	
	
	/**
	 * MÉTODO QUE DEVUELVE UNA LISTA DE TIPO T
	 * @return
	 */
	ArrayList<T> listar() throws TiendaExceptions; 
	
	/**
	 * MÉTODO QUE PERMITE BUSCA DADO SU ID
	 * @param id
	 * @return
	 */
	T buscarId(Integer id) throws TiendaExceptions; 
	
	/**
	 * MÉTODO QUE PERMITE CREAR UN DE TIPO T
	 * @param obj
	 */
	void crear(T obj) throws TiendaExceptions; 
	
	/**
	 * MÉTODO QUE PERMITE CREAR UN PRODUCTO DE TIPO T
	 * @param obj
	 */
	void actualizar(T obj)  throws TiendaExceptions; 
	/**
	 * MÉTODO QUE PERMITE ELIMINAR UN PRODUCTO DE TIPO T
	 * @param obj
	 */
	void eliminar(T obj)  throws TiendaExceptions; 
}
