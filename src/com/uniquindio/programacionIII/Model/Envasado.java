package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Envasado extends Producto{

    private LocalDate fechaEnvasado;
    private Double peso;
    
     public Envasado(String descripcion, Integer cantDisponible, String nombre, Double valor, Double peso, LocalDate fechaEnvasado) {
    	 
    	 super(descripcion, cantDisponible, nombre, valor);
    	 
     }

}
