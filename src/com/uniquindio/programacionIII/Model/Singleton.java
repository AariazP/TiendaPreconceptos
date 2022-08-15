package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Singleton {
    private static Tienda tienda;

    public static Tienda getInstance(String ciudad){
        if(tienda == null){
            tienda = new Tienda(ciudad);
        }
        return tienda;
    }

}
