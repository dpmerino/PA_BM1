/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Cajero {
    String cedula;
    String id_cajero;
    String nombre;
    String apellido;
    Transaccion transacciones;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(String id_cajero) {
        this.id_cajero = id_cajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Transaccion getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }

    public Cajero() {
    }

    public Cajero(String cedula, String id_cajero, String nombre, String apellido, Transaccion transacciones) {
        this.cedula = cedula;
        this.id_cajero = id_cajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.transacciones = transacciones;
    }

    public Cajero(String cedula, String id_cajero, String nombre, String apellido) {
        this.cedula = cedula;
        this.id_cajero = id_cajero;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
}
