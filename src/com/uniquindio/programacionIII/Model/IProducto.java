package com.uniquindio.programacionIII.Model;

import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.EscrituraException;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class IProducto implements CRUDTienda<Producto>{

	private ArrayList<Producto> productos;

	public IProducto() {

		productos = new ArrayList<>();
	}

	public void crearproductoEnvasado(String nombre, String descripcion, Integer cantDisponible, Integer temperatura,
			Double valor) {
	}

	public void crearProductoRefrigerado(String nombre, String descripcion, Integer cantDisponible, Integer temperatura,
			Double valor, Boolean aprobado) throws TiendaExceptions {
		
		Refrigerado refrigerado = new Refrigerado(nombre, descripcion, cantDisponible, valor, aprobado, valor);
		
		if(!existeProducto(refrigerado)) {
			crear(refrigerado);
		}else {
			throw new EscrituraException("Ya existe ese producto");
		}

	}

	private boolean existeProducto(Refrigerado refrigerado) {
		return productos.stream().filter(e -> e.equals(refrigerado)).findFirst().isPresent(); 

	}

	@Override
	public ArrayList<Producto> listar() throws TiendaExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto buscarId(Integer id) throws TiendaExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Producto obj) throws TiendaExceptions {
		productos.add(obj);
	}

	@Override
	public void actualizar(Producto obj) throws TiendaExceptions {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Producto obj) throws TiendaExceptions {
		// TODO Auto-generated method stub

	}



}
