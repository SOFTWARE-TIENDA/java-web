/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import app.DatabaseConfig.Conexion;
import app.DatabaseConfig.GestorJDBC;
import app.DatabaseConfig.GestorJDBCPostgre;
import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.UserDao;
import model.Usuario;
/**
 *
 * @author josel
 */
public class UsuarioService{
    UserDao userDAO;
    Conexion conexao = new Conexion();
    GestorJDBC gestor;
    public UsuarioService(){
        gestor = new GestorJDBCPostgre();
        userDAO = new UserDao(gestor);
    }
    public String EncryptionPassword(String password){
          String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
         return bcryptHashString;
     }
     public boolean desencriptionPassword(String password,String hashingpassword){
         BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashingpassword);
        return result.verified;
     }
        
    public Usuario authenticatedUser(String email,String password) throws Exception{
            gestor.abrirConexion();
             Usuario usuario  = userDAO.authenticated(email);
             gestor.cerrarConexion();
             return usuario;
    }
    
    
}
