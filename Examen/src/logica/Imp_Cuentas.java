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
public class Imp_Cuentas {
    public static ArrayList<Cuenta> ImportarCuentas(){   
            // PARA CARGAR LOS ARRAYS DE PAQUETES Y CLIENTES DESDE UN ARCHIVO TEXTO,
            // PARA ESTE EJEMPLO TENEMOS UN SOLO ARCHIVO, SE PUEDE TENER LOS QUE UDS. QUIERAN
            // PREFERIBLE SEPARAR POR CLASES
        ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
        File f = new File("Archivos/cuentas.txt"); 
        ManCliente objManCli = new ManCliente();
        Imp_Cli objImpCli = new Imp_Cli();
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        String aNumero;
        int aTipo;
        double aSaldo;
        String aCedula;
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            ArrayClientes = objImpCli.ImportarClientes();
            entrada = new Scanner(f);
            while (entrada.hasNext()) {            
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()){
                    aNumero = st.nextToken();
                    aTipo = Integer.parseInt(st.nextToken());
                    aSaldo = Double.parseDouble(st.nextToken());
                    aCedula = st.nextToken();
                    Cuenta objTmpChi = new Cuenta(aNumero,aTipo,aSaldo,objManCli.BuscarCliente(ArrayClientes,aCedula));
                    ArrayCuentas.add(objTmpChi);
                }
            }                      
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayCuentas;
    }    
         
    public static void GuardaArchivoChip(ArrayList<Cuenta> ArrayCuentas) throws FileNotFoundException, IOException{
        // SE DEBE MANTENER LA MISMA ESTRUCTURA DEL ARCHIVO DE ENTRADA PARA QUE FUNCIONE
        // LO DEBEN COMPLETAR UDS.
        File f = new File("Archivos/Chips.txt");
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cuenta objCue : ArrayCuentas) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objCue.getNumero()+",");
            bw.write(objCue.getTipo()+",");
            bw.write(objCue.getSaldo()+",");
            bw.write(objCue.getCliente().getCedula()+"\n");
        }
        bw.close();
        fw.close();
    }
}
