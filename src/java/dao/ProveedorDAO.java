package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;

    public List<Proveedor> listar() {
        List<Proveedor> listaProv = null;

        try {
            String sql = "SELECT * FROM Proveedor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            listaProv = new ArrayList();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                p.setNombreproveedor(rs.getString("Nombre_Proveedor"));
                p.setEmail(rs.getString("Email"));
                p.setTelefono(rs.getString("Telefono"));

                listaProv.add(p);

            }
        } catch (SQLException e) {
            System.out.println("Error leyendo registros");
        }
        return listaProv;
    }

    public void agregar(Proveedor p) {
        try {
            String sql = "INSERT INTO Proveedor (Codigo_Proveedor, Nombre_Proveedor, Email, Telefono) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoproveedor());
            ps.setString(2, p.getNombreproveedor());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelefono());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error agregando registro");
        }
    }

    public Proveedor buscar(String idp) {
        Proveedor tmp = null;

        try {
            String sql = "SELECT * FROM Proveedor WHERE Codigo_Proveedor = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idp);

            rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Proveedor();

                tmp.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                tmp.setNombreproveedor(rs.getString("Nombre_Proveedor"));
                tmp.setEmail(rs.getString("Email"));
                tmp.setTelefono(rs.getString("Telefono"));

            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public Proveedor buscar(Proveedor p) {
        Proveedor tmp = null;

        try {
            String sql = "SELECT * FROM Proveedor WHERE Codigo_Proveedor = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoproveedor());

            rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Proveedor();

                tmp.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                tmp.setNombreproveedor(rs.getString("Nombre_Proveedor"));
                tmp.setEmail(rs.getString("Email"));
                tmp.setTelefono(rs.getString("Telefono"));
            }

        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public void actualizar(Proveedor p) {
        try {
            String sql = "UPDATE Proveedor SET Nombre_Proveedor = ?, Email = ?, Telefono = ? WHERE Codigo_Proveedor = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreproveedor());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelefono());
            ps.setInt(4, p.getCodigoproveedor());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando registro");
        }

    }
    
    public void eliminar (Proveedor p){
        try {
            String sql = "DELETE FROM Proveedor WHERE Codigo_Proveedor = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoproveedor());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando registro");
        }
    }
}
