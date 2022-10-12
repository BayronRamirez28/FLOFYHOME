package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetallePedido;

public class DetallePedidoDAO {
    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<DetallePedido> listar(){
        List<DetallePedido> listaDePe = null;
        
        try {
            String sql = "SELECT * FROM Detalle_Pedido";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaDePe = new ArrayList();
            
            while (rs.next()){
                DetallePedido depe = new DetallePedido();
                depe.setCodigopedido(rs.getInt("Codigo_Pedido"));
                depe.setCantidad(rs.getInt("Cantidad"));
                depe.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                PedidoDAO pedidodao = new PedidoDAO();
                depe.setPedido(pedidodao.buscar(rs.getString("Codigo_Pedido")));
                
                ProductoDAO prodao = new ProductoDAO();
                depe.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
                
                listaDePe.add(depe);
            }
            
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");    
        }
        return listaDePe;
    }
    
    public DetallePedido buscar (String iddp){
        DetallePedido tmp = null;
        
        try {
            String sql = "SELECT * FROM Detalle_Pedido WHERE Codigo_Pedido = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, iddp);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new DetallePedido();
                        
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
    public DetallePedido buscar (DetallePedido depe){
        DetallePedido tmp = null;
        
        try {
            String sql = "SELECT * FROM Detalle_Pedido WHERE Codigo_Pedido = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, depe.getCodigopedido());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new DetallePedido();
                
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                PedidoDAO pedidodao = new PedidoDAO();
                tmp.setPedido(pedidodao.buscar(rs.getString("Codigo_Pedido")));
                
                ProductoDAO prodao = new ProductoDAO();
                tmp.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
}
