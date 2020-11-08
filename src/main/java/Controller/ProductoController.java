/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getParameter("action");
            switch(action){
                case "changeproducto":
                    updatePromocion(request,response);
                    break;
                case "changedescuento":
                    updateDescuento(request,response);
                    break;
                default:
                    break;
            }
    }
        private void listarPromociones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           try{
                response.setContentType("application/json");
            List<Producto> promociones=  productoservice.getPromociones();
           JsonElement element = gson.toJsonTree(promociones,new TypeToken<List<Producto>>(){}.getType());
           JsonArray jsonArray = element.getAsJsonArray();
             response.getWriter().print(jsonArray);
           }catch(Exception ex){
               System.out.println("promotion list "+ ex);
           }
        }
        private void listarProductos(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
          try{
                response.setContentType("application/json");
            List<Producto> productos= productoservice.getProductos(); //get array with object
            JsonElement element = gson.toJsonTree(productos,new TypeToken<List<Producto>>(){}.getType());
            JsonArray jsonArray = element.getAsJsonArray();
            if(jsonArray != null){
                response.getWriter().print(jsonArray);
                response.setStatus(200);
            }else{
                response.getWriter().print("problema en listar productos");
                response.setStatus(400);
            }
          }catch(Exception ex){
              System.out.println(" list products " + ex);
          }
        }
        private void listarConsultas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            //consulta en 3 parametros
            try{
             response.setContentType("application/json");  
            Map consulta = productoservice.getData();
              String jsonStr = gson.toJson(consulta);
               if(jsonStr != null){
                   response.getWriter().print(jsonStr);
                response.setStatus(200);
            }else{
                response.getWriter().print("problema en consultas");
                response.setStatus(400);
            }
            }catch(Exception ex){
                System.out.println("list querys " +ex);
            }
        }
        private void updatePromocion(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
            try{
                 String id = request.getParameter("id");
            double descuento = Double.parseDouble(request.getParameter("descuento"));
            String codigo = request.getParameter("codigoproducto");
            SimpleDateFormat _sdf= new SimpleDateFormat("yyyy-MM-dd");
                String fecha = _sdf.format(new Date());
           int update =  productoservice.updateProduct(id, fecha, descuento, codigo);
            if( 0 < update){
                response.setStatus(200);
            }
            }catch(Exception ex){
                  System.out.println("promotion update " +ex);
            }
        }
        private void updateDescuento(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
           try{
                 response.setStatus(200);
             String id = request.getParameter("id");
            double descuento = Double.parseDouble(request.getParameter("descuento"));
             int update = productoservice.updateDescuento(id, descuento);
            if( 0 < update){
                listarPromociones(request,response);
            }else{
                response.getWriter().print("problema en consultas");
                response.setStatus(400);
            }
           }catch(Exception ex){
               System.out.println("descuento update " +ex);
           }
                 
        }
        
     
}
