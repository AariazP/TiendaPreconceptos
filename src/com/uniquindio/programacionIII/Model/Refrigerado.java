package com.uniquindio.programacionIII.Model;


public class Refrigerado extends Producto{
	
	
    private Boolean aprobado;
    private Double temperatura;
    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String tipo;

    public Refrigerado(String nombre, String descripcion, Integer cantDisponible, Double valor, Boolean aprobado, Double temperatura){
    	
        super(descripcion, cantDisponible, nombre, valor);
        this.aprobado = aprobado;
        this.temperatura = temperatura;
        this.tipo = "Refrigerado";
        
    }

}
