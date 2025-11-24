/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

/**
 *
 * @author josealanth
 */
public class SingletonSample2 {
    
    private static SingletonSample2 instance = null;
    
    private SingletonSample2(){
        
    }
    
    public static SingletonSample2 getinstance(){
        if(instance == null)
           instance = new SingletonSample2();
        return instance;
    }
}
