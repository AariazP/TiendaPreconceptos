package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor


public class Perecedero extends Producto{

    private LocalDate fechaVencimiento;
    private String tipo;

    public Perecedero(String descripcion, Integer cantDisponible, String nombre, Double valor, LocalDate fechaVencimiento){
    	super(descripcion, cantDisponible, nombre, valor);
    	this.fechaVencimiento = fechaVencimiento; 
    	this.tipo = "Perecedero";
    }

}
