package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;

public class VentaDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;

    public List<Venta> listar() {
        List<Venta> listaVen = null;

        try {
            String sql = "SELECT * FROM Venta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            listaVen = new ArrayList();

            while (rs.next()) {
                Venta ven = new Venta();
                ven.setCodigoventa(rs.getInt("Codigo_Venta"));
                ven.setFecha(rs.getDate("Fecha"));
                ven.setSubtotal(rs.getFloat("Subtotal"));
                ven.setTotal(rs.getFloat("Total"));
                ven.setCodigovendedor(rs.getInt("Codigo_Vendedor"));
                ven.setCodigopedido(rs.getInt("Codigo_Pedido"));
                ven.setCodigodireccion(rs.getInt("Codigo_Direccion"));

                UsuarioDAO usudao = new UsuarioDAO();
                ven.setVendedor(usudao.buscar(rs.getString("Codigo_Vendedor")));

                PedidoDAO pedidodao = new PedidoDAO();
                ven.setPedido(pedidodao.buscar(rs.getString("Codigo_Pedido")));

                DireccionDAO direcciondao = new DireccionDAO();
                ven.setDireccion(direcciondao.buscar(rs.getString("Codigo_Direccion")));

                listaVen.add(ven);
            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }
        return listaVen;
    }
    
    public Venta buscar (String idvn){
        Venta tmp = null;
        
        try {
            String sql = "SELECT * FROM Venta WHERE Codigo_Venta = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idvn);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Venta();
                
                tmp.setCodigoventa(rs.getInt("Codigo_Venta"));
                tmp.setFecha(rs.getDate("Fecha"));
                tmp.setSubtotal(rs.getFloat("Subtotal"));
                tmp.setTotal(rs.getFloat("Total"));
                tmp.setCodigovendedor(rs.getInt("Codigo_Vendedor"));
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
    public Venta buscar (Venta ven){
        Venta tmp = null;
        
        try {
            String sql = "SELECT * FROM Venta WHERE Codigo_Venta = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ven.getCodigoventa());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Venta();
                
                tmp.setCodigoventa(rs.getInt("Codigo_Venta"));
                tmp.setFecha(rs.getDate("Fecha"));
                tmp.setSubtotal(rs.getFloat("Subtotal"));
                tmp.setTotal(rs.getFloat("Total"));
                tmp.setCodigovendedor(rs.getInt("Codigo_Vendedor"));
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                
                UsuarioDAO usudao = new UsuarioDAO();
                tmp.setVendedor(usudao.buscar(rs.getString("Codigo_Vendedor")));
                
                PedidoDAO pedidodao = new PedidoDAO();
                tmp.setPedido(pedidodao.buscar(rs.getString("Codigo_Pedido")));
                
                DireccionDAO direcciondao = new DireccionDAO();
                tmp.setDireccion(direcciondao.buscar(rs.getString("Codigo_Direccion")));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
}
