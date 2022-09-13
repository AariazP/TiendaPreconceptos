package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;


public class Singleton {
	
	private static Tienda tienda;

	public static Tienda getInstance(String ciudad){
		if(tienda == null){
			tienda = new Tienda(ciudad);
		}
		return tienda;
	}


	public static Tienda getInstance(){
		if(tienda == null){
			tienda = new Tienda();
		}
		return tienda;
	}

	public static void crearClienteNatural(String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String email, LocalDate fecha) throws TiendaExceptions {

		getInstance().crearClienteNatural(nombre, apellidos, identificacion, direccion, telefono, email, fecha);

	}


	public static ArrayList<Cliente> getClientes() {
		return getInstance().getListaClientes();
	}


	public static void crearClienteJuridico(String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String nit, String idTributaria) throws TiendaExceptions {
		getInstance().crearClienteJuridico(nombre,apellidos,identificacion,direccion,telefono, nit, idTributaria); 		
	}


	public static void eliminarCliente(Cliente clienteSelected) throws TiendaExceptions {
		getInstance().eliminarCliente(clienteSelected);
	}


	public static void actualizarClienteNatural(Cliente cliente, String nombre, String apellidos, String identificacion,
			String direccion, String telefono, String email, LocalDate fecha) {
		
		getInstance().actualizarClienteNatural(cliente,nombre, apellidos, identificacion, direccion, telefono, email, fecha);
	}


	public static void crearProductoEnvasado(String nombre, String descripcion, Integer cantDisponible,
			LocalDate fechaEnvasado, Double peso, String pais, Double valor) throws TiendaExceptions {
		getInstance().crearProductoEnvasado(nombre, descripcion, cantDisponible, fechaEnvasado, peso, pais, valor);
	}


	public static void crearProductoRefrigerado(String nombre, String descripcion, Integer cantDisponible,
			Integer temperatura, Double valor, Boolean aprobado) throws TiendaExceptions {
		getInstance().crearProductoRefrigerado(nombre, descripcion, cantDisponible, temperatura, valor, aprobado);
	}


	public static ArrayList<Producto> getProductos() {
		return getInstance().getListaProductos();
	}


	public static void crearProductoPerecedero(String descripcion, Integer cantDisponible, String nombre, Double valor,
			LocalDate fechaVencimiento) throws TiendaExceptions {
		getInstance().crearProductoPerecedero(descripcion, cantDisponible, nombre, valor, fechaVencimiento);
	}


	public static void actualizarProductoEnvasado(Envasado productoSelected, String nombre, String descripcion,
			LocalDate fecha, String pais, Double peso, Double valor, Integer cantDisponible) {
		getInstance().actualizarProductoEnvasado(productoSelected, nombre, descripcion, fecha, pais, peso, valor, cantDisponible); 
	}


	public static void actualizarProductoPerecedero(Perecedero productoSelected, String nombre, String descripcion,
			LocalDate fechaVencimiento, Integer cantDisponible, Double valor) {
		
		getInstance().actualizarProductoPerecedero(productoSelected,nombre, descripcion, fechaVencimiento, cantDisponible, valor);
		
	}


	public static void actualizarProductoRefrigerado(Refrigerado productoSelected, String nombre, String descripcion,
			Integer cantDisponible, Double temperatura, Double valor, Boolean aprobado) {
		getInstance().actualizarProductoRefrigerado((Refrigerado) productoSelected, nombre, descripcion, cantDisponible, temperatura, valor, aprobado); 
	}


	public static void eliminarProducto(Producto productoSelected) throws TiendaExceptions {
		getInstance().eliminarCliente(productoSelected);
	}


	public static boolean existeDisponibilidad(Producto productoSelected, Integer cantidadComprada) {
		return getInstance().existeDisponibilidad(productoSelected, cantidadComprada);
	}


	public static void reducirCantidadProducto(Producto productoSelected, Integer cantidadComprada) {
		getInstance().reducirCantidadProducto(productoSelected, cantidadComprada);
	}



}
