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
         String type="postgresql";
//         String type="mysql";
        //?useSSL=false => mysql
         try {  
        String host="ec2-3-95-87-221.compute-1.amazonaws.com";
        String user="iadtrawmfvjzwh";
        String password="c643fe00c328bf0948751f44e7f8b40e15fc05d7af256e7911553f37341c79af";
        String port="5432";
        String database="dam792urv1f2kp";
//        String url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?useSSL=false";
            String url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?sslmode=require";
            //siempre definir bien el url y añadir el class for name ...
             Class.forName("org.postgresql.Driver");
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
    public void closeConexion(){
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
    }
    
   
   
}
