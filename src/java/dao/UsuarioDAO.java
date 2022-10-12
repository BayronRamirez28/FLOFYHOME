package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;


public class UsuarioDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;

    public List<Usuario> listar() {
        List<Usuario> listaUsu = null;

        try {
            String sql = "SELECT * FROM Usuario as U join Rol as R on U.Codigo_Rol = R.Codigo_Rol";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            listaUsu = new ArrayList();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCodigousuario(rs.getInt("Codigo_Usuario"));
                u.setNombreusuario(rs.getString("Nombre_Usuario"));
                u.setEstado(rs.getString("Estado"));
                u.setTipodocumento(rs.getString("Tipo_Documento"));
                u.setDni(rs.getString("DNI"));
                u.setContraseña(rs.getString("Contraseña"));
                u.setEmail(rs.getString("Email"));
                u.setTelefono(rs.getString("Telefono"));
                u.setCodigorol(rs.getInt("Codigo_Rol"));
                u.setNombrerol(rs.getString("Nombre_Rol"));

                listaUsu.add(u);

            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }

        return listaUsu;

    }

    public void agregar(Usuario u) {
        String sql = "INSERT INTO Usuario (Codigo_Usuario, Nombre_Usuario, Estado, Tipo_Documento, DNI, Contraseña, Email, Telefono, Codigo_Rol) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getCodigousuario());
            ps.setString(2, u.getNombreusuario());
            ps.setString(3, u.getEstado());
            ps.setString(4, u.getTipodocumento());
            ps.setString(5, u.getDni());
            ps.setString(6, u.getContraseña());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getTelefono());
            ps.setInt(9, u.getCodigorol());

            ps.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Error agregando Persona");
        }
    }
    
    public Usuario buscar(String idus){
        Usuario tmp = null;
        
        try {
            String sql = "SELECT * FROM Usuario WHERE Codigo_Usuario = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idus);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Usuario();
                
                tmp.setCodigousuario(rs.getInt("Codigo_Usuario"));
                tmp.setNombreusuario(rs.getString("Nombre_Usuario"));
                tmp.setEstado(rs.getString("Estado"));
                tmp.setTipodocumento(rs.getString("Tipo_Documento"));
                tmp.setDni(rs.getString("DNI"));
                tmp.setContraseña(rs.getString("Contraseña"));
                tmp.setEmail(rs.getString("Email"));
                tmp.setTelefono(rs.getString("Telefono"));
                tmp.setCodigorol(rs.getInt("Codigo_Rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public Usuario buscar(Usuario u) {
        Usuario tmp = null;

        try {
            String sql = "SELECT * FROM Usuario WHERE Codigo_Usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getCodigousuario());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Usuario();
                tmp.setCodigousuario(rs.getInt("Codigo_Usuario"));
                tmp.setNombreusuario(rs.getString("Nombre_Usuario"));
                tmp.setEstado(rs.getString("Estado"));
                tmp.setTipodocumento(rs.getString("Tipo_Documento"));
                tmp.setDni(rs.getString("DNI"));
                tmp.setContraseña(rs.getString("Contraseña"));
                tmp.setEmail(rs.getString("Email"));
                tmp.setTelefono(rs.getString("Telefono"));
                tmp.setCodigorol(rs.getInt("Codigo_Rol"));

            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public void actualizar(Usuario u) {
        try {
            String sql = "UPDATE Usuario SET Nombre_Usuario = ?, Estado = ?, Tipo_Documento = ?, DNI = ?, Contraseña = ?, Email = ?, Telefono = ?, Codigo_Rol = ? WHERE Codigo_Usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombreusuario());
            ps.setString(2, u.getEstado());
            ps.setString(3, u.getTipodocumento());
            ps.setString(4, u.getDni());
            ps.setString(5, u.getContraseña());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getTelefono());
            ps.setInt(8, u.getCodigorol());
            ps.setInt(9, u.getCodigousuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando registro");
        }

    }

}
