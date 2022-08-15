package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor


public class Perecederos extends Producto{

    private LocalDate fechaVencimiento;

    public Perecederos(){
        super();
    }

}
