package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Producto {

    private static int codAux =0;

    private String nombre, aboutProduct, id;
    private Double valor;
    private int cantDisponible;

    public Producto(){

    }
    public Producto(String aboutProduct, int cantDisponible, String nombre, Double valor) {

        this.aboutProduct = aboutProduct;
        this.cantDisponible = cantDisponible;
        this.nombre = nombre;
        this.valor = valor;
        id = ++codAux +"";
    }


}
