/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDAO.IProductoDao;
import app.DatabaseConfig.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Producto;

/**
 *
 * @author josel
 */
public class ProductoDao implements IProductoDao{
     GestorJDBC gestor;
     public ProductoDao(GestorJDBC gestor){
         this.gestor=gestor;
     }
    
     PreparedStatement query1,query2,query3;
     ResultSet re1,re2,re3;
     String [] sqlquerys = {IProductoDao.TOTALPRODUCTO,IProductoDao.MINIMACANTIDAD,IProductoDao.MAXIMACANTIDAD};
     String [] output = {"totalproducto","NombreMinimo","NombreMayor"};
     PreparedStatement [] pres ={query1,query2,query3};
     ResultSet [] res = {re1,re2,re3};
    private Map data = new HashMap();
    @Override
    public Map getTotalProducto()  throws SQLException{
              for(int i=0;i<pres.length;i++){
                  pres[i] = gestor.prepararSentencia(sqlquerys[i]);
                  res[i]= pres[i].executeQuery();
                  if(res[i].next()){
                      data.put(output[i], res[i].getString(output[i]));
                  }
              }
             return data;
    }
    public List<Producto> getListProducto() throws SQLException {
          ArrayList<Producto> list = new ArrayList<>();
          Producto pro;
          PreparedStatement  query4 = gestor.prepararSentencia(IProductoDao.PRODUCTOS);
           ResultSet re4 = query4.executeQuery();
            while(re4.next()){
               pro = new Producto(re4.getString("cod_producto"),
                       re4.getString("nombre"),
                       re4.getInt("cantidad"),
                       re4.getDouble("precioventa"),
                       re4.getString("imagenid"),
                       re4.getString("imageUrl"),
                      0,
                      ""
               );
               list.add(pro);
            }
             return list;
    }
     public List getListPromociones()  throws SQLException  {
        Producto pro;
            ArrayList<Producto> list = new ArrayList<>();
          PreparedStatement  query5 = gestor.prepararSentencia(IProductoDao.PROMOCIONES);
          ResultSet  re5 = query5.executeQuery();
            while(re5.next()){
                  pro = new Producto(re5.getString("cod_producto"),
                         re5.getString("nombre"),
                       0,
                       re5.getDouble("precioventa"),
                       re5.getString("imagenid"),
                       re5.getString("imageUrl"),
                       re5.getDouble("oferta"),
                       re5.getString("fecha_apertura")
               );
                     list.add(pro);
            }
           return list;
     }
     public int updatePromocion(String id,String fecha,Double descuento,String codigo) throws SQLException {
           PreparedStatement  query6 =  gestor.prepararSentencia(IProductoDao.PRODUCTOSUPDATE);
             query6.setString(1, fecha);
             query6.setDouble(2, descuento);
             query6.setString(3, codigo);
             query6.setString(4,id);
             int resultadoPromocion = query6.executeUpdate();
             return resultadoPromocion;
     }
     public int updateDescuento(String id,double descuento) throws SQLException{
           PreparedStatement  query7 = gestor.prepararSentencia(IProductoDao.PROMOCIONDESCUENTO);
             query7.setDouble(1, descuento);
             query7.setString(2, id);
             int resultadoDescuento = query7.executeUpdate();
             System.out.println("update descuento " + resultadoDescuento);
             return resultadoDescuento;
     }
}
