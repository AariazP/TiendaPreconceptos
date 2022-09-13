package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

public class Envasado extends Producto{

    public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}


	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Paises getPais() {
		return pais;
	}


	public void setPais(Paises pais) {
		this.pais = pais;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	private LocalDate fechaEnvasado;
    private Double peso;
    private Paises pais; 
    private String tipo;
    
     public Envasado(String nombre, String descripcion, Integer cantDisponible, LocalDate fechaEnvasado, Double peso, String pais, Double valor) {
    	 
    	 
    	 super(descripcion, cantDisponible, nombre, valor);
    	 this.fechaEnvasado = fechaEnvasado;
    	 this.peso = peso;
    	 this.pais = definirPais(pais);
    	 this.tipo = "Envasado";
    	 
     }


	private Paises definirPais(String pais) {
		
		if(pais.equals("Colombia")) return Paises.COLOMBIA;
		
		if(pais.equals("Argentina")) return Paises.ARGENTINA;
		
		if(pais.equals("Chile")) return Paises.CHILE;
		
		if(pais.equals("Ecuador")) return Paises.ECUADOR;
		
		if(pais.equals("Peru")) return Paises.PERU;
		
		return null;
	}

}
