/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import model.Usuario;

/**
 *
 * @author josel
 */
public class UsuarioService{
    
    private UserDao userdao= new UserDao();
    public Usuario authenticatedUser(String email,String password){
        try{
            System.out.println("service here ..");
        if(email.equals("") || password.equals("")){
                return null;
        }else{
             Usuario usuario  = userdao.authenticated(email, password);
             return usuario;
        }
        }catch(Exception ex){
            System.out.println("error "+ ex);
        }
        return null;
    }
    
    
}
