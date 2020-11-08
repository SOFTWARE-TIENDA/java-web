/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import app.DatabaseConfig.Conexion;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import service.UsuarioService;

/**
 *
 * @author josel
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {
    UsuarioService userservice = new UsuarioService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
           session.removeAttribute("usuario");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
          PrintWriter writer = response.getWriter(); 
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          Usuario user=null;
        try {
            user = userservice.authenticatedUser(email, password);
          if(email.equals("") || password.equals("")){
            response.setStatus(400);
            writer.write("completar campos");
           }    
          if(user != null){
           if(userservice.desencriptionPassword(password,user.getPassword())){
                session.setAttribute("usuario",user.getNombre()+" "+user.getApellido());
                response.setStatus(200);
           }else{
                response.setStatus(400);
                writer.write("*Usuario y password no coinciden");
           }
        }else{
            response.setStatus(400);
            writer.write("El Email ingresado no existe");
        }
        } catch (Exception ex) {
           System.out.println("problema user " + ex);
        }
       
    }


}
