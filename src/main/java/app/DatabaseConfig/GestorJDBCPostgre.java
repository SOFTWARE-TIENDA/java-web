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
            String host="ec2-3-95-87-221.compute-1.amazonaws.com";
            String user="iadtrawmfvjzwh";
            String password="c643fe00c328bf0948751f44e7f8b40e15fc05d7af256e7911553f37341c79af";
            String port="5432";
            String database="dam792urv1f2kp";
            String url = "jdbc:postgresql://"+host+":"+port+"/"+database+"?sslmode=require&&?targetServerType=primary";
             Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new Exception("Error en la conexion con la base de datos de MYSQL, consulte con el administrador." + e);
        }

    }
}
