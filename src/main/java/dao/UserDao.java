/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDAO.IUserDao;
import app.DatabaseConfig.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author josel
 */
public class UserDao extends Conexion implements IUserDao{
    private final String AUTHENTICATED="SELECT * FROM usuario where email=? and contraseña=?";
    PreparedStatement pre; 
    ResultSet re;
    @Override
    public Usuario authenticated(String email,String password) {
        Usuario user;
        try{
            pre = this.getConexion().prepareStatement(AUTHENTICATED);
            pre.setString(1,email);
            pre.setString(2,password);
            re  = pre.executeQuery();
            if(re.next()){
                user = new Usuario(
                        re.getString("nombre"),
                        re.getString("apellido"));
                 return user;
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println("error " + e);
        }
        return null;
    }
}
