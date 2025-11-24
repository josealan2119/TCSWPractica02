/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josealanth
 */
public class ConexionDB {
    
    private static ConexionDB instance = null;
    
    public static ConexionDB getinstance(){
        if(instance == null)
            instance = new ConexionDB();
        return instance;
    }
    
    private String url = "jdbc:postgresql://localhost:5432/ejemplo";
    private String usr = "postgres";
    private String psw = "210125";
    private Connection con = null;
    
    private ConexionDB(){
        try {
            con = DriverManager.getConnection(url,usr,psw);     
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Se conecto");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean execute(String sql){
        Statement st = null;
        try {
            st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
        }finally{
            try {
                if(st != null)
                    st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public ResultSet select(String sql) {
        Statement st = null;
        try { 
            st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
//        } finally {
//            try {
//                if (st != null) {
//                    st.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
      }
    }
    
    public boolean execute(TransactionDB t){
        return t.execute(con);
    }
}
