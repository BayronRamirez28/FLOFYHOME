package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleVenta;

public class DetalleVentaDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<DetalleVenta> listar(){
        List<DetalleVenta> listaDV = null;
        
        try {
            String sql = "SELECT * FROM Detalle_Venta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaDV = new ArrayList();
            
            while (rs.next()){
                DetalleVenta dv = new DetalleVenta();
                dv.setCodigoventa(rs.getInt("Codigo_Venta"));
                dv.setCantidad(rs.getInt("Cantidad"));
                dv.setValoru(rs.getFloat("Valor_U"));
                dv.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                VentaDAO ventadao = new VentaDAO();
                dv.setVenta(ventadao.buscar(rs.getString("Codigo_Venta")));
                
                ProductoDAO prodao = new ProductoDAO();
                dv.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
                
                listaDV.add(dv);
            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }
        return listaDV;
    }
    
    public DetalleVenta buscar (String iddv){
        DetalleVenta tmp = null;
        
          try {
            String sql = "SELECT * FROM Detalle_Venta WHERE Codigo_Venta = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, iddv);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new DetalleVenta();
                
                tmp.setCodigoventa(rs.getInt("Codigo_Venta"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setValoru(rs.getFloat("Valor_U"));
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                
            }
        } catch (SQLException e) {
              System.out.println("Error buscando registro");
        }
          return tmp;
    }
    
    public DetalleVenta buscar (DetalleVenta dv){
        DetalleVenta tmp = null;
        
        try {
            String sql = "SELECT * FROM Detalle_Venta WHERE Codigo_Venta = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getCodigoventa());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new DetalleVenta();
                
                tmp.setCodigoventa(rs.getInt("Codigo_Venta"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setValoru(rs.getFloat("Valor_U"));
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                VentaDAO ventadao = new VentaDAO();
                tmp.setVenta(ventadao.buscar(rs.getString("Codigo_Venta")));
                
                ProductoDAO prodao = new ProductoDAO();
                tmp.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
}
