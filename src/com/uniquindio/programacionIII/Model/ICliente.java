package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import com.uniquindio.programacionIII.Exceptions.EscrituraException;
import com.uniquindio.programacionIII.Exceptions.TiendaExceptions;


public class ICliente implements CRUDTienda<Cliente> {

    public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	private ArrayList<Cliente> clientes;
    
    
    public ICliente() {
    	clientes = new ArrayList<>();
    }

	@Override
	public ArrayList<Cliente> listar() throws TiendaExceptions {
		return null;
	}


	@Override
	public Cliente buscarId(Integer id) throws TiendaExceptions {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void crear(Cliente obj) throws TiendaExceptions {
		if(!existeCliente(obj)) {
			clientes.add(obj);
		}else {
			throw new EscrituraException("Ya existe un cliente con esa informacion"); 
		}
	}

	/**
	 * Metodo que verifica si existe un cliente en la lista clientes
	 * @param obj
	 * @return
	 */
	public boolean existeCliente(Cliente obj) {
		
		return clientes.stream().filter(e -> e.equals(obj)).findFirst().isPresent();
		
	}

	@Override
	public void actualizar(Cliente obj) throws TiendaExceptions {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(Cliente obj) throws TiendaExceptions {
		
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).equals(obj)) clientes.remove(obj);
		}
		
	}

	public void crearClienteNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono,
			String email, LocalDate fecha) throws TiendaExceptions {
		
		ClienteNatural clienteNatural = new ClienteNatural(nombre, apellidos, identificacion, direccion, telefono, email, fecha);
		crear(clienteNatural);
	}

	public void crearClienteJuridico(String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String nit, String idTributaria) throws TiendaExceptions {
		
		ClienteJuridico clienteJuridico = new ClienteJuridico(nombre, apellidos, identificacion, direccion, telefono, nit, idTributaria);
		crear(clienteJuridico);
	}

	public void actualizarClienteNatural(Cliente cliente, String nombre, String apellidos, String identificacion, String direccion,
			String telefono, String email, LocalDate fecha) {
		
		ClienteNatural clienteNatural = (ClienteNatural) cliente;
		
		clienteNatural.setNombre(nombre);
		clienteNatural.setApellido(apellidos);
		clienteNatural.setIdentificacion(identificacion);
		clienteNatural.setDireccion(direccion);
		clienteNatural.setTelefono(telefono);
		clienteNatural.setEmail(email);
		clienteNatural.setFechaNacimiento(fecha);
		
	}
	
}
