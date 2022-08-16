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
public class ICliente implements CRUDTienda<Cliente> {

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
	private boolean existeCliente(Cliente obj) {
		
		clientes.stream().anyMatch(e-> e.equals(obj));
		
		return false;
	}

	@Override
	public void actualizar(Cliente obj) throws TiendaExceptions {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Eliminar(Cliente obj) throws TiendaExceptions {
		// TODO Auto-generated method stub
		
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
}
