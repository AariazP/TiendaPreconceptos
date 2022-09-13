package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.EscrituraException;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;


public class IProducto implements CRUDTienda<Producto>{

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

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
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i) == obj) productos.remove(i);
		}
	}

	public void crearproductoEnvasado(String nombre, String descripcion, Integer cantDisponible,
			LocalDate fechaEnvasado, Double peso, String pais, Double valor) throws TiendaExceptions {

		Envasado envasado = new Envasado(nombre, descripcion, cantDisponible, fechaEnvasado, peso, pais, valor);
		crear(envasado);
	}

	public void crearProdcutoPerecedero(String descripcion, Integer cantDisponible, String nombre, Double valor,
			LocalDate fechaVencimiento) throws TiendaExceptions {
		Perecedero perecedero = new Perecedero(descripcion, cantDisponible, nombre, valor, fechaVencimiento);
		crear(perecedero);
	}

	public void actualizarProductoEnvasado(Envasado productoSelected, String nombre, String descripcion,
			LocalDate fecha, String pais, Double peso, Double valor, Integer cantDisponible) {


		productoSelected.setNombre(nombre);
		productoSelected.setAboutProduct(descripcion);
		productoSelected.setFechaEnvasado(fecha);
		productoSelected.setPais(definirPais(pais));
		productoSelected.setPeso(peso);
		productoSelected.setValor(valor);
		productoSelected.setCantDisponible(cantDisponible);
		
	}

	private Paises definirPais(String pais) {

		if(pais.equals("Colombia")) return Paises.COLOMBIA;

		if(pais.equals("Argentina")) return Paises.ARGENTINA;

		if(pais.equals("Chile")) return Paises.CHILE;

		if(pais.equals("Ecuador")) return Paises.ECUADOR;

		if(pais.equals("Peru")) return Paises.PERU;

		return null;
	}

	public void actualizarProductoPerecedero(Perecedero productoSelected, String nombre, String descripcion,
			LocalDate fechaVencimiento, Integer cantDisponible, Double valor) {
		
		productoSelected.setNombre(nombre);
		productoSelected.setAboutProduct(descripcion);
		productoSelected.setFechaVencimiento(fechaVencimiento);
		productoSelected.setValor(valor);
		productoSelected.setCantDisponible(cantDisponible);
	}

	public void actualizarProductoRefrigerado(Refrigerado productoSelected, String nombre, String descripcion,
			Integer cantDisponible, Double temperatura, Double valor, Boolean aprobado) {
		
		productoSelected.setNombre(nombre);
		productoSelected.setAboutProduct(descripcion);
		productoSelected.setCantDisponible(cantDisponible);
		productoSelected.setTemperatura(temperatura);
		productoSelected.setValor(valor);
		productoSelected.setAprobado(aprobado);
		
	}

	public boolean existeDisponibilidad(Producto productoSelected, Integer cantidadComprada) {
		return productoSelected.getCantDisponible() <= cantidadComprada ? true:false;
	}

	public void reducirCantidadProducto(Producto productoSelected, Integer cantidadComprada) {
		productoSelected.reducirCantidadProducto(cantidadComprada);
	}
	

}
