/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductoService;

/**
 *
 * @author josel
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {
     Gson gson = new Gson();   
    ProductoService productoservice = new ProductoService();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String action = request.getParameter("action");
              switch(action){
                  case "listarpromocion":
                      listarPromociones(request,response);
                      break;
                  case "listarproductos":
                      listarProductos(request,response);
                      break;
                  case "listarconsultas":
                      listarConsultas(request,response);
                      break;
                  default:
                     listarProductos(request,response);
                      break;
              }
    }
        private void listarPromociones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            response.setContentType("application/json");
            List<Producto> promociones=  productoservice.getPromociones();
           JsonElement element = gson.toJsonTree(promociones,new TypeToken<List<Producto>>(){}.getType());
            JsonArray jsonArray = element.getAsJsonArray();
            System.out.println(jsonArray);
             response.getWriter().print(jsonArray);
        }
        private void listarProductos(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
            response.setContentType("application/json");
            List<Producto> productos= productoservice.getProductos(); //get array with object
            JsonElement element = gson.toJsonTree(productos,new TypeToken<List<Producto>>(){}.getType());
            JsonArray jsonArray = element.getAsJsonArray();
              System.out.println(jsonArray);
            if(jsonArray != null){
                response.setStatus(200);
                response.getWriter().print(jsonArray);
            }else{
                response.getWriter().print("problema en listar productos");
                response.setStatus(400);
            }
        }
        private void listarConsultas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
              response.setContentType("application/json");  
            Map consulta = productoservice.getData();
              String jsonStr = gson.toJson(consulta);
               if(jsonStr != null){
                response.setStatus(200);
                response.getWriter().print(jsonStr);
            }else{
                response.getWriter().print("problema en consultas");
                response.setStatus(400);
            }
        }
        
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
     }
}
