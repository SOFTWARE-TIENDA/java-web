/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DatabaseConfig;

import java.sql.DriverManager;

/**
 *
 * @author josel
 */
public class GestorJDBCMysql extends GestorJDBC{
      @Override
    public void abrirConexion() throws Exception {
        try {
               String host="localhost";
            String user="root";
            String password="root";
            String port="3306";
            String database="javatienda";
            String url = "jdbc:mysql://"+host+":"+port+"/"+database;
             Class.forName("com.mysql.jdbc.Driver");
             conexion = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new Exception("Error en la conexion con la base de datos de Mysql, consulte con el administrador." + e);
        }

    }

}
