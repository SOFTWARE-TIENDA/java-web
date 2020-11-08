/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDAO.IUserDao;
import app.DatabaseConfig.Conexion;
import app.DatabaseConfig.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author josel
 */
public class UserDao implements IUserDao{
     GestorJDBC gestor;
     public UserDao(GestorJDBC gestor){
         this.gestor=gestor;
     }
    @Override
    public Usuario authenticated(String email) throws SQLException {
                Usuario user=null;
           PreparedStatement pre = gestor.prepararSentencia(AUTHENTICATED);
            pre.setString(1,email);
           ResultSet re  = pre.executeQuery();
            if(re.next()){
                user = new Usuario(
                        re.getString("nombre"),
                        re.getString("apellido"),
                        re.getString("password")
                );
            }
            return user;
       }
}
