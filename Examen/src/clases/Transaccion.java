/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Administrador
 */
public class Transaccion {
    int id_transaccion;
    Cliente cliente;
    Cajero cajero;
    Cuenta cuenta;

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, Cliente cliente, Cajero cajero, Cuenta cuenta) {
        this.id_transaccion = id_transaccion;
        this.cliente = cliente;
        this.cajero = cajero;
        this.cuenta = cuenta;
    }
    
}
