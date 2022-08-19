package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
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

	public void crearProductoRefrigerado(String nombre, String descripcion, Integer cantDisponible, Integer temperatura,
			Double valor, Boolean aprobado) throws TiendaExceptions {

		Refrigerado refrigerado = new Refrigerado(nombre, descripcion, cantDisponible, valor, aprobado, valor);
		crear(refrigerado);

	}

	private boolean existeProducto(Producto producto) {
		return productos.stream().filter(e -> e.equals(producto)).findFirst().isPresent(); 

	}

	@Override
	public ArrayList<Producto> listar() throws TiendaExceptions {
		return null;
	}

	@Override
	public Producto buscarId(Integer id) throws TiendaExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Producto obj) throws TiendaExceptions {
		if(!existeProducto(obj)) {
			productos.add(obj);
		}else {
			throw new EscrituraException("Ya existe ese producto");
		}
	}

	@Override
	public void actualizar(Producto obj) throws TiendaExceptions {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Producto obj) throws TiendaExceptions {
		// TODO Auto-generated method stub

	}

	public void crearproductoEnvasado(String nombre, String descripcion, Integer cantDisponible,
			LocalDate fechaEnvasado, Double peso, String pais, Double valor) throws TiendaExceptions {

		Envasado envasado = new Envasado(nombre, descripcion, cantDisponible, fechaEnvasado, peso, pais, valor);
		crear(envasado);
	}



}
