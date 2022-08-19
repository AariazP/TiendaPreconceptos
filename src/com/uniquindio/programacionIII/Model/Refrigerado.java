package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Refrigerado extends Producto{
	
	
    private Boolean aprobado;
    private Double temperatura;
    private String tipo;

    public Refrigerado(String nombre, String descripcion, Integer cantDisponible, Double valor, Boolean aprobado, Double temperatura){
    	
        super(descripcion, cantDisponible, nombre, valor);
        this.aprobado = aprobado;
        this.temperatura = temperatura;
        this.tipo = "Refrigerado";
        
    }

}
