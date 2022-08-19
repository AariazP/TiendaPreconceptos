package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Tienda {

    private String ciudad;
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

}
