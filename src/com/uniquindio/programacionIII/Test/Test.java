package com.uniquindio.programacionIII.Test;

import java.time.LocalDate;

import com.uniquindio.programacionIII.Model.ClienteNatural;
import com.uniquindio.programacionIII.Model.ICliente;

public class Test {

	public static void main(String[] args) {
		LocalDate fecha = LocalDate.now();
		
		ClienteNatural cliente1 = new ClienteNatural("a", fecha, "a");
		ClienteNatural cliente2 = new ClienteNatural("a", fecha, "a");
		
		
		ICliente clientes = new ICliente();
		
		
		clientes.getClientes().add(cliente1);
		boolean re = clientes.existeCliente(cliente2);
		System.out.println(re);
		
	}

}
