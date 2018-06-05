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
public class Cuenta {
    String numero;
    int tipo; //1 para cuenta ahorros y 2 para cuenta corriente
    double saldo;
    Cliente cliente;
    ArrayList<Cliente> ArrayClientes;
    Transaccion transacciones;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transaccion getTrancsacciones() {
        return transacciones;
    }

    public void setTrancsacciones(Transaccion trancsacciones) {
        this.transacciones = trancsacciones;
    }

    public ArrayList<Cliente> getArrayClientes() {
        return ArrayClientes;
    }

    public void setArrayClientes(ArrayList<Cliente> ArrayClientes) {
        this.ArrayClientes = ArrayClientes;
    }
    
    public Cuenta() {
    }

    public Cuenta(String numero, int tipo, double saldo, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    public Cuenta(String numero, int tipo, double saldo, ArrayList<Cliente> ArrayClientes){
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.ArrayClientes = ArrayClientes;
    }
    
    public Cuenta(String numero, int tipo, double saldo, Cliente cliente, Transaccion transacciones) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", ArrayClientes=" + ArrayClientes + '}';
    }
    
    
}
