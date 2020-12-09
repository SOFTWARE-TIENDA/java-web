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
            String host="ec2-3-208-50-226.compute-1.amazonaws.com";
            String user="puhpdvsrudzyxt";
            String password="3c490415e62f6f9239844a9e45d070ea27da3d9669f04e37426bcc4a6b379c07";
            String port="5432";
            String database="ddl6bjifq5a25k";
            String url = "jdbc:postgresql://"+host+":"+port+"/"+database+"?sslmode=require&&?targetServerType=primary";
             Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new Exception("Error en la conexion con la base de datos de MYSQL, consulte con el administrador." + e);
        }

    }
}
