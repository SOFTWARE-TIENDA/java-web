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
public class GestorJDBCPostgre extends GestorJDBC{
     @Override
     public void abrirConexion() throws Exception {
        try {
            String host="isilo.db.elephantsql.com";
            String user="vmycjgoi";
            String password="CpQTLo7xIdUl6ECoKxcxPKZU6_Gb4dNV";
            String port="5432";
            String database="vmycjgoi";
            String url = "jdbc:postgresql://"+host+":"+port+"/"+database+"?sslmode=require&&?targetServerType=primary";
             Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new Exception("Error en la conexion con la base de datos de POSTGRE, consulte con el administrador." + e);
        }

    }
}
