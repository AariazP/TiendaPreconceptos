package com.uniquindio.programacionIII.Model;

import java.util.Objects;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
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


	@Override
	public int hashCode() {
		return Objects.hash(apellido, direccion, id, identificacion, nombre, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(identificacion, other.identificacion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}


}
