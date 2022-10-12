package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Lote;

public class LoteDAO {
    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Lote> listar(){
        List<Lote> listaLot = null;
        
        try {
            String sql = "SELECT * FROM Lote";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaLot = new ArrayList();
            
            while(rs.next()){
                Lote l = new Lote();
                l.setCodigolote(rs.getInt("Codigo_Lote"));
                l.setCantidad(rs.getInt("Cantidad"));
                l.setFechalote(rs.getDate("Fecha_Lote"));
                l.setFechavencimiento(rs.getDate("Fecha_Vencimiento"));
                l.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                ProductoDAO prodao = new ProductoDAO();
                l.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
                
                listaLot.add(l);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }
        return listaLot;
    }
    public Lote buscar(Lote l){
        Lote tmp = null;
        
        try {
            String sql = "SELECT * FROM Lote WHERE Codigo_Lote = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, l.getCodigolote());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Lote();
                tmp.setCodigolote(rs.getInt("Codigo_Lote"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setFechalote(rs.getDate("Fecha_Lote"));
                tmp.setFechavencimiento(rs.getDate("Fecha_Vencimiento"));
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                
                ProductoDAO prodao = new ProductoDAO();
                tmp.setProducto(prodao.buscar(rs.getString("Codigo_Producto")));
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
    
    public void agregar (Lote l){
        try {
            String sql = "INSERT INTO LOTE (Codigo_Lote, Cantidad, Fecha_Lote, Fecha_Vencimiento, Codigo_Producto) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, l.getCodigolote());
            ps.setInt(2, l.getCantidad());
            ps.setDate(3, l.getFechalote());
            ps.setDate(4, l.getFechavencimiento());
            ps.setInt(5, l.getCodigoproducto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error agregando registro");
        }
    }
    
    
    public void actualizar(Lote l){
        try {
            String sql = "UPDATE Lote SET Cantidad = ?, Fecha_Lote = ?, Fecha_Vencimiento = ?, Codigo_Producto = ? WHERE Codigo_Lote = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, l.getCantidad());
            ps.setDate(2, l.getFechalote());
            ps.setDate(3, l.getFechavencimiento());
            ps.setInt(4, l.getCodigoproducto());
            ps.setInt(5, l.getCodigolote());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando registro");
        }
    }
    
    public void eliminar (Lote l){
        try {
            String sql = "DELETE FROM Lote WHERE Codigo_Lote = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, l.getCodigolote());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando registor");
        }
    }
}
