/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Cliente;
import clases.Cuenta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ManCuenta {
    public Cuenta CrearCuenta(String numero, int tipo, double saldo, Cliente cliente){
        Cuenta objCue = new Cuenta(numero, tipo, saldo, cliente);
        return objCue;
    }
    public Cuenta BuscarCuenta(ArrayList<Cuenta> ArrayCuentas, String numero) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cuenta objAux = new Cuenta();
        for (Cuenta objCue : ArrayCuentas) {// RECORRER EL ARRAYLIST
            String strCe = objCue.getNumero().trim();
            if (strCe.equals(numero.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objCue;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    public Cuenta DepositoCuenta(Cuenta cuenta, double deposito){
        Cuenta objAux = new Cuenta();
        objAux = cuenta;
        double aux = objAux.getSaldo();
        aux = aux+deposito;
        objAux.setSaldo(aux);
        return objAux;
    }
    public Cuenta RetiroCuenta (Cuenta cuenta, double retiro){
        Cuenta objAux = new Cuenta();
        objAux = cuenta;
        if (objAux.getTipo()==1) {
            double aux = objAux.getSaldo();
            aux = aux - retiro;
            objAux.setSaldo(aux);
            if (objAux.getSaldo()<20) {
                objAux = cuenta;
            }
        }
        if (objAux.getTipo()==2) {
            double aux = objAux.getSaldo();
            aux = aux - retiro;
            objAux.setSaldo(aux);
            if (objAux.getSaldo()<50) {
                objAux = cuenta;
            }
        }
        return objAux;
    }
    public static void GuardarCuenta (ArrayList<Cuenta> ArrayCuentas) throws IOException{
        File f = new File("Archivos/cuentas.txt");
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cuenta objCue : ArrayCuentas){
            bw.write(objCue.getNumero()+",");
            bw.write(objCue.getTipo()+",");
            bw.write(objCue.getSaldo()+",");
            bw.write(objCue.getCliente().getCedula()+"\n");
        }
        bw.close();
        fw.close();
    }
}
