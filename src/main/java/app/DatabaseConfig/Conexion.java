/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josel
 */
public class Conexion {
    private String type;
    private String host;
    private String user;
    private String password;
    private String port;
    private String database;
    private String URL;
    Connection con=null;
    public Connection getConexion(){
         String type="mysql";
        //?useSSL=false => mysql
         try {  
        String host="localhost";
        String user="root";
        String password="root";
        String port="3306";
        String database="javaproyecto";
        String url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?useSSL=false";
            //siempre definir bien el url y añadir el class for name ...
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url,user,password);
             if(con != null){
                 System.out.println("conexion establecida");
                 return con;
             }
         } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
        
    }
  
    
   
   
}
