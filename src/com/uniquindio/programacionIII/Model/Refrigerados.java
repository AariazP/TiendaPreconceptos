package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Refrigerados extends Producto{
	
	
    private Boolean aprobado;
    private Double temperatura;

    public Refrigerados(){
        super();
    }

}
