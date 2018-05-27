/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Cajero;
import clases.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ManCajero {
    public Cajero CrearCajero(String cedula, String id_cajero, String nombre, String apellido){
        Cajero objCaj = new Cajero(cedula, id_cajero, nombre, apellido);
        return objCaj;
    }
        public Cajero BuscarCajero(ArrayList<Cajero> ArrayCajeros, String id_cajero) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cajero objAux = new Cajero();
        for (Cajero objCaj : ArrayCajeros) {// RECORRER EL ARRAYLIST
            String strCe = objCaj.getId_cajero().trim();
            if (strCe.equals(id_cajero.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objCaj;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
}
