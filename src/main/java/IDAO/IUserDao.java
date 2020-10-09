/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import model.Usuario;

/**
 *
 * @author josel
 */
public interface IUserDao {
    public Usuario authenticated(String email,String password);
}
