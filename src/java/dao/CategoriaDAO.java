package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;

    public List<Categoria> listar() {
        List<Categoria> listaCate = null;

        try {
            String sql = "SELECT * FROM Categoria";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            listaCate = new ArrayList();

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setCodigocategoria(rs.getInt("Codigo_Categoria"));
                c.setNombrecategoria(rs.getString("Nombre_Categoria"));

                listaCate.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error leyendo registros");
        }
        return listaCate;
    }

    public Categoria buscar(String idc) {
        Categoria tmp = null;

        try {
            String sql = "SELECT * FROM Categoria WHERE Codigo_Categoria = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idc);

            rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Categoria();

                tmp.setCodigocategoria(rs.getInt("Codigo_Categoria"));
                tmp.setNombrecategoria(rs.getString("Nombre_Categoria"));

            }

        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public Categoria buscar(Categoria c) {
        Categoria tmp = null;

        try {
            String sql = "SELECT * FROM Categoria WHERE Codigo_Categoria = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigocategoria());

            rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Categoria();

                tmp.setCodigocategoria(rs.getInt("Codigo_Categoria"));
                tmp.setNombrecategoria(rs.getString("Nombre_Categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando ");
        }
        return tmp;
    }

}
