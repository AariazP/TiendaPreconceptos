package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Envasados extends Producto{

    private LocalDate fechaEnvasado;
    private Double peso;


}
