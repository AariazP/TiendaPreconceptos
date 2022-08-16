package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ClienteJuridico extends Cliente{

    private String nit, idTributaria, tipo;
    
    
    public ClienteJuridico(String nombre, String apellido, String identificacion, String direccion, String telefono,
    		String nit, String idTributaria) {
    	
    	super(nombre, apellido, identificacion, direccion, telefono);
    	this.nit = nit;
    	this.idTributaria=idTributaria;
    	this.tipo = "Juridico";
    	
    }
    
}
