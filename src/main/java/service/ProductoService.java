/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import app.DatabaseConfig.GestorJDBC;
import app.DatabaseConfig.GestorJDBCPostgre;
import dao.ProductoDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author josel
 */
public class ProductoService {
    ProductoDao productodao;
    GestorJDBC gestor;
    public ProductoService(){
        gestor = new GestorJDBCPostgre();
        productodao = new ProductoDao(gestor);
    }
    public Map getData() throws Exception{
      
        gestor.abrirConexion();
          Map total = new HashMap();
         total = productodao.getTotalProducto();
         gestor.cerrarConexion();
         return total;
    }
    public List getProductos() throws Exception{
        gestor.abrirConexion();
         List lista;
         lista = productodao.getListProducto();
         gestor.cerrarConexion();
         return lista;
    }
    public List getPromociones() throws Exception{
          gestor.abrirConexion();
         List lista;
         lista = productodao.getListPromociones();
         gestor.cerrarConexion();
         return lista;

    }
    public int updateProduct(String id,String fecha,Double descuento,String codigo)throws Exception {
        gestor.abrirConexion();
       
        try{
             gestor.iniciarTransaccion();
             int updateProduct = productodao.updatePromocion(id,fecha,descuento,codigo);
            gestor.terminarTransaccion();
            return updateProduct;
        }catch(Exception e){
        gestor.cancelarTransaccion();
            throw e;
        }
    }
    public int updateDescuento(String id,double descuento) throws Exception{
         gestor.abrirConexion();
        try{
        gestor.iniciarTransaccion();
        int updateProduct = productodao.updateDescuento(id,descuento);
        gestor.terminarTransaccion();
        return updateProduct;
        }catch(Exception e){
            gestor.cancelarTransaccion();
            throw e;
        }
    }
}
