package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Tienda {

    private String ciudad;
    private ICliente clientes;
    private IProducto productos;


    public Tienda(String ciudad){
        this.ciudad = ciudad;
    }

}
