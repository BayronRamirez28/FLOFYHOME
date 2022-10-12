package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Direccion;

public class DireccionDAO {
    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Direccion> listar(){
        List<Direccion> listaDir = null;
        
        try {
            String sql = "SELECT * FROM Direccion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            listaDir = new ArrayList();
            
            while(rs.next()){
                Direccion dr = new Direccion();
                dr.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                dr.setDireccion(rs.getString("Direccion"));
                dr.setCodigousuario(rs.getInt("Codigo_Usuario"));
                
                UsuarioDAO usudao = new UsuarioDAO();
                dr.setUsuario(usudao.buscar(rs.getString("Codigo_Usuario")));
                
                listaDir.add(dr);
            }
            
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }
        return listaDir;
    }
    
    public Direccion buscar(String iddr){
        Direccion tmp = null;
        
        try {
            String sql = "SELECT * FROM Direccion WHERE Codigo_Direccion = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, iddr);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Direccion();
                
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                tmp.setDireccion(rs.getString("Direccion"));
                tmp.setCodigousuario(rs.getInt("Codigo_Usuario"));
                

            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
    
    public Direccion buscar (Direccion dr){
        Direccion tmp = null;
        
        try {
            String sql = "SELECT * FORM Direccion WHERE Codigo_Direccion = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dr.getCodigodireccion());
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Direccion();
                tmp.setCodigodireccion(rs.getInt("Codigo_Direccion"));
                tmp.setDireccion(rs.getString("Direccion"));
                tmp.setCodigousuario(rs.getInt("Codigo_Usuario"));
                
                UsuarioDAO usudao = new UsuarioDAO();
                tmp.setUsuario(usudao.buscar(rs.getString("Codigo_Usuario")));
                
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }
}
