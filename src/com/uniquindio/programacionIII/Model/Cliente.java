package com.uniquindio.programacionIII.Model;

import lombok.*;


@Getter
@Setter
public class Cliente {

    private String nombre, apellido, identificacion, direccion, telefono;
    private static int aux = 0;
    private int id;
    
    
    public Cliente() {
    	
    }


	public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.id = ++aux;
	}


}
