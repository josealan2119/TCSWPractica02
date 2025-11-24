/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josealanth
 */
public class SingletonSample {
    
    private static SingletonSample instancia = null;
    
    public static int a;
    
    public static void principal(){
         Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Metodo");
    }
    
    static{
         Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Bloque");

    }
    
    
}
