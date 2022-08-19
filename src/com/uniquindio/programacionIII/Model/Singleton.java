package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

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

}
