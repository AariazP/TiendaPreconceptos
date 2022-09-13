package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;




public class Perecedero extends Producto{

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private LocalDate fechaVencimiento;
    private String tipo;

    public Perecedero(String descripcion, Integer cantDisponible, String nombre, Double valor, LocalDate fechaVencimiento){
    	super(descripcion, cantDisponible, nombre, valor);
    	this.fechaVencimiento = fechaVencimiento; 
    	this.tipo = "Perecedero";
    }

}
