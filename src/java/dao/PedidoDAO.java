package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

public class PedidoDAO {
    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Pedido> listar(){
        List<Pedido> listaPer = null;
        
        try {
            String sql = "SELECT * FROM Pedido";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaPer = new ArrayList();
            
            while(rs.next()){
                Pedido ped = new Pedido();
                ped.setCodigopedido(rs.getInt("Codigo_Pedido"));
                ped.setFecha(rs.getDate("Fecha"));
                ped.setCodigocliente(rs.getInt("Codigo_Cliente"));
                ped.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                
                UsuarioDAO usudao = new UsuarioDAO();
                ped.setUsuario(usudao.buscar(rs.getString("Codigo_Usuario")));
                
                DireccionDAO direcciondao = new DireccionDAO();
                ped.setDireccion(direcciondao.buscar(rs.getString("Codigo_Direccion")));
                
                listaPer.add(ped);
            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }
        return listaPer;
    }
    
    public Pedido buscar (String idpe){
        Pedido tmp = null;
        
        try {
            String sql = "SELECT * FROM Pedido WHERE Codigo_Pedido = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idpe);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Pedido();
                
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setFecha(rs.getDate("Fecha"));
                tmp.setCodigocliente(rs.getInt("Codigo_Cliente"));
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
            }
                    
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
    public Pedido buscar (Pedido ped){
        Pedido tmp = null;
        
        try {
            String sql = "SELECT * FROM Pedido WHERE Codigo_Pedido = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getCodigopedido());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Pedido();
                
                tmp.setCodigopedido(rs.getInt("Codigo_Pedido"));
                tmp.setFecha(rs.getDate("Fecha"));
                tmp.setCodigocliente(rs.getInt("Codigo_Cliente"));
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                
                UsuarioDAO usudao = new UsuarioDAO();
                tmp.setUsuario(usudao.buscar(rs.getString("Codigo_Cliente")));
                
                DireccionDAO direcciondao = new DireccionDAO();
                tmp.setDireccion(direcciondao.buscar(rs.getString("Codigo_Direccion")));
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
}
