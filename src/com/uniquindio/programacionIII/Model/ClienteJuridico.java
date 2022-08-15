package com.uniquindio.programacionIII.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ClienteJuridico extends Cliente{

    private String nit, idTributaria;
    
}
