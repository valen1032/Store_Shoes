package com.valentina.tienda_zapatos.Entidades;

import java.io.Serializable;

public class Producto implements Serializable {

    private int id;

    private String nombre;
    private String Descripcion;
    private String precio;
    private String marca;


    public Producto(String nombre, String descripcion, String precio, String marca) {
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.precio = precio;
        this.marca= marca;
    }

    public Producto(String nombre, String descripcion, String precio, String marca, int id) {
        this.id = id;
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.precio = precio;
        this.marca= marca;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto(int id, String nombre, String descripcion, String precio, String marca) {
        this.id = id;
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.precio = precio;
        this.marca= marca;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", marca=" + marca +
                '}';
    }
}
