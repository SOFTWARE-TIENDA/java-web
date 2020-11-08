/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author josel
 */
public class Usuario {
    private int id;
    private String nombre;
    private String password;
    private String apellido;
    private String email;
    private String cargo;
    
    public Usuario(String nombre,String apellido,String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password=password;
    }
   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

  
  
}
