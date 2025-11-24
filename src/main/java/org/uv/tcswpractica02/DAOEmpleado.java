/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josealanth
 */
public class DAOEmpleado implements IDAOGeneral<PojoEmpleado, Long> {

    @Override
    public boolean guardar(PojoEmpleado pojo) {
        ConexionDB con = ConexionDB.getinstance();
        TransactionDB t = new TransactionDB<PojoEmpleado>(pojo) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "INSERT INTO empleados (clave, nombre, direccion, telefono)"
                            + "values (?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setLong(1, pojo.getClave());
                    pst.setString(2, pojo.getNombre());
                    pst.setString(3, pojo.getDireccion());
                    pst.setString(4, pojo.getTelefono());
                    pst.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        };
        return con.execute(t);
    }

    @Override
    public PojoEmpleado eliminar(Long Clave) {
         try {
            String sql = "DELETE FROM empleados WHERE clave = " + Clave;
            ConexionDB con = ConexionDB.getinstance();
            if (con.execute(sql)) {
                return new PojoEmpleado(Clave, null, null, null);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PojoEmpleado modificar(PojoEmpleado pojo, Long clave) {
        String sql = "UPDATE empleados SET "
            + "nombre = '" + pojo.getNombre() + "', "
            + "direccion = '" + pojo.getDireccion() + "', "
            + "telefono = '" + pojo.getTelefono() + "' "
            + "WHERE clave = " + clave;
        ConexionDB con = ConexionDB.getinstance();
        if (con.execute(sql)) {
            return pojo;
        } else {
            return null;
        }
    }

    @Override
    public PojoEmpleado findByID(Long clave) {
        try {
            String sql = "SELECT * FROM empleados WHERE clave = "+clave;
            
            ConexionDB con = ConexionDB.getinstance();
            ResultSet set = con.select(sql);
            
            if(set.next()){
                PojoEmpleado pojo = new PojoEmpleado();
                pojo.setClave(set.getLong(1));
                pojo.setNombre(set.getString(2));
                pojo.setDireccion(set.getString(3));
                pojo.setTelefono(set.getString(4));
                return pojo;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
               
    }

    @Override
    public List<PojoEmpleado> findAll() {
        try {
            List<PojoEmpleado> empleados = new ArrayList<PojoEmpleado>();
            String sql = "SELECT clave, nombre, direccion, telefono FROM empleados";
            
            ConexionDB con = ConexionDB.getinstance();
            
            ResultSet set = con.select(sql);
            
            while(set.next()){
                PojoEmpleado pojo = new PojoEmpleado();
                        pojo.setClave(set.getLong("clave"));
                        pojo.setNombre(set.getString("nombre"));
                        pojo.setDireccion(set.getString("direccion"));
                        pojo.setTelefono(set.getString("telefono"));
                 empleados.add(pojo);
            }
            return empleados;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }

}


    