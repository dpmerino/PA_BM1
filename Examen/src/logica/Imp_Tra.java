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
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author utpl
 */
public class Imp_Tra {
    
    public static ArrayList<Transaccion> ImportarTransaccion(){   
        ArrayList<Transaccion> ArrayTransacciones = new ArrayList<Transaccion>();
        File f = new File("Archivos/transaccion.txt");        
        StringTokenizer st;
        Scanner entrada = null;
        //Cliente
        ManCliente objManCli = new ManCliente();
        Imp_Cli objImpCli = new Imp_Cli();
        //Cuenta
        ManCuenta objManCue = new ManCuenta();
        Imp_Cuentas objImpCue = new Imp_Cuentas();
        //Cajero
        ManCajero objManCaj = new ManCajero();
        Imp_Caj objImpCaj = new Imp_Caj();
        //Importar ArrayList de clientes,cajero,cuentas
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
        ArrayList<Cajero> ArrayCajeros = new ArrayList<Cajero>();
        String sCadena;
        int aId;
        String aCedula;
        String aCuenta;
        String aCajero;
        try {
            ArrayClientes = objImpCli.ImportarClientes();
            ArrayCajeros = objImpCaj.ImportarCajeros();
            ArrayCuentas = objImpCue.ImportarCuentas();
            entrada = new Scanner(f);
            while (entrada.hasNext()) {            
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()){
                    aId = Integer.parseInt(st.nextToken());
                    aCedula = st.nextToken();
                    aCajero = st.nextToken();
                    aCuenta = st.nextToken();
                    Transaccion objTmpTra = new Transaccion(aId,objManCli.BuscarCliente(ArrayClientes, aCedula),objManCaj.BuscarCajero(ArrayCajeros, aCajero),objManCue.BuscarCuenta(ArrayCuentas, aCuenta));
                    ArrayTransacciones.add(objTmpTra);
                }
            }                      
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayTransacciones;
    }    
         
    public static void GuardaArchivoCliente(ArrayList<Cliente> ArrayClientes) throws FileNotFoundException, IOException{
        File f = new File("Archivos/Clientes.txt");
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cliente objCli : ArrayClientes) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objCli.getCedula()+",");
            bw.write(objCli.getNombre()+",");
            bw.write(objCli.getApellido()+"\n");
        }
        bw.close();
        fw.close();
    }
}
