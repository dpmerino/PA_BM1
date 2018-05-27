package logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import clases.Cajero;
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
public class Imp_Caj {
    
    public static ArrayList<Cajero> ImportarCajeros(){   
        ArrayList<Cajero> ArrayCajeros = new ArrayList<Cajero>();
        File f = new File("Archivos/cajeros.txt");        
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {            
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()){
                    Cajero objTmpCli = new Cajero(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
                    ArrayCajeros.add(objTmpCli);
                }
            }                      
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayCajeros;
    }    
         
//    public static void GuardaArchivoCliente(ArrayList<Cliente> ArrayClientes) throws FileNotFoundException, IOException{
//        File f = new File("Archivos/Clientes.txt");
//        FileWriter fw = new FileWriter(f,false);
//        BufferedWriter bw = new BufferedWriter(fw);
//        for (Cliente objCli : ArrayClientes) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
//            bw.write(objCli.getCedula()+",");
//            bw.write(objCli.getNombres()+",");
//            bw.write(objCli. getApellidos()+"\n");
//        }
//        bw.close();
//        fw.close();
//    }
}
