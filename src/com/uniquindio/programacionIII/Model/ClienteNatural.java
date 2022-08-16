
package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor

public class ClienteNatural extends Cliente{

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
