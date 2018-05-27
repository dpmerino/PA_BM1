/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Cajero;
import clases.Cliente;
import clases.Cuenta;
import clases.Transaccion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ManTransaccion {
    public Transaccion CrearTransaccion(Cliente cliente, Cajero cajero, Cuenta cuenta,ArrayList<Transaccion> ArrayTransacciones){ 
        int aux = ArrayTransacciones.size()+1;

        Transaccion objTra = new Transaccion (aux, cliente, cajero, cuenta);
        return objTra;
    }
    public static void GuardaTransaccion(ArrayList<Transaccion> ArrayTransacciones) throws FileNotFoundException, IOException{
        // SE DEBE MANTENER LA MISMA ESTRUCTURA DEL ARCHIVO DE ENTRADA PARA QUE FUNCIONE
        // LO DEBEN COMPLETAR UDS.
        File f = new File("Archivos/transaccion.txt");
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Transaccion objTra : ArrayTransacciones) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objTra.getId_transaccion()+",");
            bw.write(objTra.getCliente().getCedula()+",");
            bw.write(objTra.getCajero().getId_cajero()+",");
            bw.write(objTra.getCuenta().getNumero()+"\n");
        }
        bw.close();
        fw.close();
    }
}
