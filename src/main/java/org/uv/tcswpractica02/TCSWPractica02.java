/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.tcswpractica02;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josealanth
 */
public class TCSWPractica02 {

    public static void main(String[] args) {
        DAOEmpleado dao = new DAOEmpleado();
        
        List p = new ArrayList<PojoEmpleado>();
        
       
        
        p = dao.findAll();
        
        System.out.println(p.size());
            
        
        
        
       PojoEmpleado pojo = new PojoEmpleado();
       pojo.setNombre("Juan");
       pojo.setDireccion("Campeche");
       pojo.setTelefono("4663372");
       
       dao.modificar(pojo, Long.valueOf(102));
       
       pojo = dao.findByID(Long.valueOf(102));
        System.out.println(pojo.getDireccion());
//        pojo.setClave(101);
//        pojo.setNombre("Ariadna");
//        pojo.setDireccion("Chocaman veracruz");
//        pojo.setTelefono("4747583");
//        boolean res = dao.guardar(pojo);
//        if (res) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "Se guardo");
//        }else{
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "No se guardo");
// 
        }
    }

