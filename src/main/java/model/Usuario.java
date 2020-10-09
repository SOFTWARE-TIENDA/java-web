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
    private String apellido;
    private String email;
    private String contraseña;
    private String telefono;
    private String cargo;
    
    public Usuario(String nombre,String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
   
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", cargo=" + cargo + '}';
    }

  
  
}
