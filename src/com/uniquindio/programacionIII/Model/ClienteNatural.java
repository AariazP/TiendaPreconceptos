package com.uniquindio.programacionIII.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor

public class ClienteNatural extends Cliente{

    private String email;
    private LocalDate fechaNacimiento;
}
