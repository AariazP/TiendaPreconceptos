package com.uniquindio.programacionIII.Model;



public class Producto {

    public static int getCodAux() {
        return codAux;
    }
    public static void setCodAux(int codAux) {
        Producto.codAux = codAux;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAboutProduct() {
        return aboutProduct;
    }
    public void setAboutProduct(String aboutProduct) {
        this.aboutProduct = aboutProduct;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getCantDisponible() {
        return cantDisponible;
    }
    public void setCantDisponible(Integer cantDisponible) {
        this.cantDisponible = cantDisponible;
    }
    private static int codAux =0;

    private String nombre, aboutProduct, id;
    private Double valor;
    private Integer cantDisponible;

    public Producto(){

    }
    public Producto(String aboutProduct, Integer cantDisponible, String nombre, Double valor) {

        this.aboutProduct = aboutProduct;
        this.cantDisponible = cantDisponible;
        this.nombre = nombre;
        this.valor = valor;
        id = ++codAux +"";
    }
	public Producto(String nombre2, String aboutProduct2, String id2, Double valor2, Integer cantidadComprada) {
    }
    public void reducirCantidadProducto(Integer cantidadComprada) {
		cantDisponible -= cantDisponible;
	} 


}
