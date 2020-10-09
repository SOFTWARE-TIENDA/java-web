/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author josel
 */
public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioventa;
    private String imagenid;
    private String imageUrl;
    private double descuento;

    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioventa=" + precioventa + ", imagenid=" + imagenid + ", imageUrl=" + imageUrl + '}';
    }

    public Producto(String codigo, String nombre, int cantidad, double precioventa, String imagenid, String imageUrl,double descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.imagenid = imagenid;
        this.imageUrl = imageUrl;
        this.descuento=descuento;
    }
//    public Producto(String codigo, String nombre,double precioventa, String imagenid, String imageUrl,double descuento) {
//        this.codigo = codigo;
//        this.nombre = nombre;
//        this.precioventa = precioventa;
//        this.imagenid = imagenid;
//        this.imageUrl = imageUrl;
//        this.descuento=descuento;
//    }
    
}
