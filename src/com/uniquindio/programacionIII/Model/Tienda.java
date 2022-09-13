package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;



public class Tienda {

	private String ciudad;
	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public ICliente getClientes() {
		return clientes;
	}


	public void setClientes(ICliente clientes) {
		this.clientes = clientes;
	}


	public IProducto getProductos() {
		return productos;
	}


	public void setProductos(IProducto productos) {
		this.productos = productos;
	}


	private ICliente clientes;
	private IProducto productos;


	public Tienda(String ciudad){
		this.ciudad = ciudad;
		clientes = new ICliente();
		productos = new IProducto();
	}


	public Tienda() {
		clientes = new ICliente();
		productos = new IProducto();
	}

	public void crearClienteNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono,
			String email, LocalDate fecha) throws TiendaExceptions {

		clientes.crearClienteNatural(nombre, apellidos, identificacion, direccion, telefono, email, fecha);
	}


	public ArrayList<Cliente> getListaClientes() {
		return clientes.getClientes();
	}


	public void crearClienteJuridico(String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String nit, String idTributaria) throws TiendaExceptions {

		clientes.crearClienteJuridico(nombre, apellidos, identificacion, direccion, telefono, nit, idTributaria);

	}


	public void eliminarCliente(Cliente clienteSelected) throws TiendaExceptions {
		clientes.eliminar(clienteSelected);
	}


	public void actualizarClienteNatural(Cliente cliente, String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String email, LocalDate fecha) {
		clientes.actualizarClienteNatural(cliente, nombre, apellidos, identificacion, direccion, telefono, email, fecha);
	}

	public void crearProductoRefrigerado(String nombre, String descripcion, Integer cantDisponible, Integer temperatura,
			Double valor, Boolean aprobado) throws TiendaExceptions {
		productos.crearProductoRefrigerado(nombre, descripcion, cantDisponible, temperatura, valor, aprobado);
	}


	public ArrayList<Producto> getListaProductos() {
		return productos.getProductos();
	}


	public void crearProductoEnvasado(String nombre, String descripcion, Integer cantDisponible,
			LocalDate fechaEnvasado, Double peso, String pais, Double valor) throws TiendaExceptions {
		productos.crearproductoEnvasado(nombre, descripcion, cantDisponible, fechaEnvasado, peso, pais, valor);
	}


	public void crearProductoPerecedero(String descripcion, Integer cantDisponible, String nombre, Double valor,
			LocalDate fechaVencimiento) throws TiendaExceptions {
		productos.crearProdcutoPerecedero(descripcion, cantDisponible, nombre, valor, fechaVencimiento);
	}


	public void actualizarProductoEnvasado(Envasado productoSelected, String nombre, String descripcion,
			LocalDate fecha, String pais, Double peso, Double valor, Integer cantDisponible) {
		productos.actualizarProductoEnvasado(productoSelected, nombre, descripcion, fecha, pais, peso, valor, cantDisponible);
	}


	public void actualizarProductoPerecedero(Perecedero productoSelected, String nombre, String descripcion,
			LocalDate fechaVencimiento, Integer cantDisponible, Double valor) {
		productos.actualizarProductoPerecedero(productoSelected,nombre, descripcion, fechaVencimiento, cantDisponible, valor);
	}


	public void actualizarProductoRefrigerado(Refrigerado productoSelected, String nombre, String descripcion,
			Integer cantDisponible, Double temperatura, Double valor, Boolean aprobado) {
		productos.actualizarProductoRefrigerado((Refrigerado) productoSelected, nombre, descripcion, cantDisponible, temperatura, valor, aprobado); 

	}

	public void eliminarCliente(Producto productoSelected) throws TiendaExceptions {
		productos.eliminar(productoSelected);
	}


	public boolean existeDisponibilidad(Producto productoSelected, Integer cantidadComprada) {
		return productos.existeDisponibilidad(productoSelected, cantidadComprada);
	}


	public void reducirCantidadProducto(Producto productoSelected, Integer cantidadComprada) {
		productos.reducirCantidadProducto(productoSelected, cantidadComprada);
	}

}
