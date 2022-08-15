package com.uniquindio.programacionIII.Model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class Cliente {

    private String nombre, apellido, identificacion, direccion, telefono;
    
    
    public Cliente() {
    	
    }


}
