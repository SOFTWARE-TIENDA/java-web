/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import java.sql.SQLException;
import java.util.Map;
import java.util.List;
/**
 *
 * @author josel
 */
public interface IProductoDao {
    public static final String TOTALPRODUCTO ="SELECT count(*) as totalproducto from producto";
    public static final String MINIMACANTIDAD="select nombre as NombreMinimo,cantidad from producto "
            + "order by cantidad asc limit 1";
    public static final String MAXIMACANTIDAD="select nombre as NombreMayor,cantidad from producto "
            + "order by cantidad desc limit 1";
    public static final String PRODUCTOS="select * from producto inner join "
            + "imagen_producto on producto.cod_producto=imagen_producto.codproducto";
    public static final String PROMOCIONES="select cod_producto,nombre,precioventa,imageUrl,imagenid,descuento,fecha_apertura from producto"
            + " inner join imagen_producto on producto.cod_producto=imagen_producto.codproducto "
            + "inner join promociones on producto.cod_producto=promociones.codproducto;";
    public static final String PRODUCTOSUPDATE= "update promociones set fecha_apertura=?,descuento=?,codproducto=? "
            + "where idpromociones=?";
    public static final String PROMOCIONDESCUENTO="update promociones set descuento=? where idpromociones=?";
    
    public Map getTotalProducto() throws SQLException;
    public List getListProducto() throws SQLException;
     public List getListPromociones() throws SQLException;
     
    public int updatePromocion(String id,String fecha,Double descuento,String codigo) throws SQLException;
    public int updateDescuento(String id ,double descuento) throws SQLException;
}
