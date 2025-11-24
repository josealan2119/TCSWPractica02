package org.uv.tcswpractica02;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josealanth
 */
public class PojoEmpleado {

    private long clave;
    private String direccion;
    private String nombre;
    private String telefono;

    public PojoEmpleado() {
    }

    public PojoEmpleado(long clave, String direccion, String nombre, String telefono) {
        this.clave = clave;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
