package com.uniquindio.programacionIII.Model;

import java.util.Objects;


public class Cliente {

    private String nombre, apellido, identificacion, direccion, telefono;
    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public static int getAux() {
		return aux;
	}


	public static void setAux(int aux) {
		Cliente.aux = aux;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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
