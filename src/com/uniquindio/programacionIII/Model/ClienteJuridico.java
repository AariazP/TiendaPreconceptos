package com.uniquindio.programacionIII.Model;



public class ClienteJuridico extends Cliente{

    public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getIdTributaria() {
		return idTributaria;
	}


	public void setIdTributaria(String idTributaria) {
		this.idTributaria = idTributaria;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	private String nit, idTributaria, tipo;
    
    
    public ClienteJuridico(String nombre, String apellido, String identificacion, String direccion, String telefono,
    		String nit, String idTributaria) {
    	
    	super(nombre, apellido, identificacion, direccion, telefono);
    	this.nit = nit;
    	this.idTributaria=idTributaria;
    	this.tipo = "Juridico";
    	
    }
    
}
