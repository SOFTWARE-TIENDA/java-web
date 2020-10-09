/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDAO.IProductoDao;
import app.DatabaseConfig.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Producto;

/**
 *
 * @author josel
 */
public class ProductoDao extends Conexion implements IProductoDao{
    //1 definir sentecias
     //querys get data
     PreparedStatement query1;
     PreparedStatement query2;
     PreparedStatement query3;
     //querys productos
     PreparedStatement query4;
     //querys promocion
     PreparedStatement query5;
     ResultSet re1;
     ResultSet re2;
      ResultSet re3;
      ResultSet re4;
      ResultSet re5;
      //los dos min and max con llevan a lo mismo
     String [] sqlquerys = {IProductoDao.TOTALPRODUCTO,IProductoDao.MINIMACANTIDAD,IProductoDao.MAXIMACANTIDAD};
     String [] output = {"totalproducto","NombreMinimo","NombreMayor"};
    PreparedStatement [] pres ={query1,query2,query3};
    ResultSet [] res = {re1,re2,re3};
    private Map data = new HashMap();
    @Override
    public Map getTotalProducto() {
        try {
              for(int i=0;i<pres.length;i++){
                  pres[i] = this.getConexion().prepareStatement(sqlquerys[i]);
                  res[i]= pres[i].executeQuery();
                  if(res[i].next()){
                      data.put(output[i], res[i].getString(output[i]));
                  }
                  //{totalproducto=10,nombreMnimo='Leche',nombreMayor='Arroz'};
              }
             return data;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Producto> getListProducto(){
          ArrayList<Producto> list = new ArrayList<>();
          Producto pro;
        try {
            query4 = this.getConexion().prepareStatement(IProductoDao.PRODUCTOS);
            re4 = query4.executeQuery();
            while(re4.next()){
               pro = new Producto(re4.getString("cod_producto"),
                       re4.getString("nombre"),
                       re4.getInt("cantidad"),
                       re4.getDouble("precioventa"),
                       re4.getString("imagenid"),
                       re4.getString("imageUrl"),
                      0
               );
               list.add(pro);
            }
             return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public List getListPromociones(){
        Producto pro;
         try {
            ArrayList<Producto> list = new ArrayList<>();
            query5 = this.getConexion().prepareStatement(IProductoDao.PROMOCIONES);
            re5 = query5.executeQuery();
            while(re5.next()){
                  pro = new Producto(re5.getString("cod_producto"),
                         re5.getString("nombre"),
                       0,
                       re5.getDouble("precioventa"),
                       re5.getString("imagenid"),
                       re5.getString("imageUrl"),
                       re5.getDouble("descuento")
               );
                     list.add(pro);
            }
           return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
}
