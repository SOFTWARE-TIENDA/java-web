/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductoDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Producto;

/**
 *
 * @author josel
 */
public class ProductoService {
    ProductoDao productodao = new ProductoDao();
    public Map getData(){
        Map total = new HashMap();
        try{
            total = productodao.getTotalProducto();
            if(total != null){
                return total;
            }else{
               return null; 
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    public List getProductos(){
        List lista;
        try{
           lista = productodao.getListProducto();
           if(lista != null){
               return lista;
           }else{
               return null;
           }
        }catch(Exception ex){
             System.out.println(ex);
        }
        return null;
    }
    public List getPromociones(){
        List lista;
        try{
            lista = productodao.getListPromociones();
             if(lista != null){
               return lista;
           }else{
               return null;
           }
        }catch(Exception ex){
              System.out.println(ex);
        }
         return null;
    }
}
