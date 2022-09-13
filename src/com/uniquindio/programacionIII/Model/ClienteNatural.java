
package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

public class ClienteNatural extends Cliente{

    public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	private String email;
    private LocalDate fechaNacimiento;
    private String tipo;
    
    
    public ClienteNatural(String nombre, String apellido, String identificacion, String direccion, 
    		String telefono, String email, LocalDate fechaNacimiento) {
    	
    	super(nombre, apellido, identificacion, direccion, telefono);
    	this.email = email;
    	this.fechaNacimiento = fechaNacimiento;
    	this.tipo = "Natural";
	}



	@Override
	public String toString() {
		return "ClienteNatural [email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", getNombre()="
				+ getNombre() + ", getApellido()=" + getApellido() + ", getIdentificacion()=" + getIdentificacion()
				+ ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
}
