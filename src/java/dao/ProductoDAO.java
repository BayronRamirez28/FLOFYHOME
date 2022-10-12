package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO {

    Connection con = ConexionDAO.conectar();
    PreparedStatement ps;
    ResultSet rs;

    public List<Producto> listar() {
        List<Producto> listaPro = null;

        try {
            String sql = "SELECT * FROM Producto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
          
            listaPro = new ArrayList();

            while (rs.next()) {
                Producto pr = new Producto();
                pr.setCodigoproducto(rs.getInt("Codigo_Producto"));
                pr.setNombreproducto(rs.getString("Nombre_Producto"));
                pr.setCantidad(rs.getInt("Cantidad"));
                pr.setPreciocompra(rs.getInt("Precio_Compra"));
                pr.setPrecioventa(rs.getInt("Precio_Venta"));
                pr.setEstado(rs.getString("Estado"));
                pr.setDetalle(rs.getString("Detalle"));
                pr.setCantidadminima(rs.getInt("Cantidad_Minima"));
                pr.setFoto(rs.getString("Imagen"));
                pr.setFoto_img("../imgPro/" + rs.getString("Imagen"));
                pr.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                pr.setCodigocategoria(rs.getInt("Codigo_Categoria"));
                
                ProveedorDAO provdao = new ProveedorDAO();
                pr.setProveedor(provdao.buscar(rs.getString("Codigo_Proveedor")));
                
                CategoriaDAO catedao = new CategoriaDAO();
                pr.setCategoria(catedao.buscar(rs.getString("Codigo_Categoria")));
                        
                listaPro.add(pr);

            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Base de Datos");
        }

        return listaPro;

    }

    public void agregar(Producto pr) throws SQLException{
        try {
            String sql = "INSERT INTO Producto (Codigo_Producto, Nombre_Producto, Cantidad, Precio_Compra, Precio_Venta, Estado, Detalle, Cantidad_Minima, Imagen, Codigo_Proveedor, Codigo_Categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getCodigoproducto());
            ps.setString(2, pr.getNombreproducto());
            ps.setInt(3, pr.getCantidad());
            ps.setFloat(4, pr.getPreciocompra());
            ps.setFloat(5, pr.getPrecioventa());
            ps.setString(6, pr.getEstado());
            ps.setString(7, pr.getDetalle());
            ps.setInt(8, pr.getCantidadminima());
            ps.setString(9, pr.getFoto());
            ps.setInt(10, pr.getCodigoproveedor());
            ps.setInt(11, pr.getCodigocategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Producto buscar(String idpr){
        Producto tmp = null;
        
        try {
            String sql = "SELECT * FROM Producto  WHERE Codigo_Producto = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, idpr);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                tmp = new Producto();
                
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                tmp.setNombreproducto(rs.getString("Nombre_Producto"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setPreciocompra(rs.getInt("Precio_Compra"));
                tmp.setPrecioventa(rs.getInt("Precio_Venta"));
                tmp.setEstado(rs.getString("Estado"));
                tmp.setDetalle(rs.getString("Detalle"));
                tmp.setCantidadminima(rs.getInt("Cantidad_Minima"));
                tmp.setFoto(rs.getString("Imagen"));
                tmp.setFoto_img("../imgPro/" + rs.getString("Imagen"));
                tmp.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                tmp.setCodigocategoria(rs.getInt("Codigo_Categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public Producto buscar(Producto pr) {
        Producto tmp = null;

        try {
            String sql = "SELECT  * FROM Producto WHERE Codigo_Producto = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getCodigoproducto());
            rs = ps.executeQuery();

            if (rs.next()) {
                tmp = new Producto();
                tmp.setCodigoproducto(rs.getInt("Codigo_Producto"));
                tmp.setNombreproducto(rs.getString("Nombre_Producto"));
                tmp.setCantidad(rs.getInt("Cantidad"));
                tmp.setPreciocompra(rs.getInt("Precio_Compra"));
                tmp.setPrecioventa(rs.getInt("Precio_Venta"));
                tmp.setEstado(rs.getString("Estado"));
                tmp.setDetalle(rs.getString("Detalle"));
                tmp.setCantidadminima(rs.getInt("Cantidad_Minima"));
                tmp.setFoto(rs.getString("Imagen"));
                tmp.setFoto_img("../imgPro/" + rs.getString("Imagen"));
                tmp.setCodigoproveedor(rs.getInt("Codigo_Proveedor"));
                tmp.setCodigocategoria(rs.getInt("Codigo_Categoria"));
                
                ProveedorDAO provdao = new ProveedorDAO();
                tmp.setProveedor(provdao.buscar(rs.getString("Codigo_Proveedor")));
                
                CategoriaDAO catedao = new CategoriaDAO();
                tmp.setCategoria(catedao.buscar(rs.getString("Codigo_Categoria")));
            }
        } catch (SQLException e) {
            System.out.println("Error buscando registro");
        }
        return tmp;
    }

    public void actualizar(Producto pr) {
        try {
            String sql = "UPDATE Producto SET Nombre_Producto = ?, Cantidad = ?, Precio_Compra = ?, Precio_Venta = ?, Estado = ?, Detalle = ?, Cantidad_Minima = ?, Imagen = ?, Codigo_Proveedor = ?, Codigo_Categoria = ? WHERE Codigo_Producto = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombreproducto());
            ps.setInt(2, pr.getCantidad());
            ps.setFloat(3, pr.getPreciocompra());
            ps.setFloat(4, pr.getPrecioventa());
            ps.setString(5, pr.getEstado());
            ps.setString(6, pr.getDetalle());
            ps.setInt(7, pr.getCantidadminima());
            ps.setString(8, pr.getFoto());
            ps.setInt(9, pr.getCodigoproveedor());
            ps.setInt(10, pr.getCodigocategoria());
            ps.setInt(11, pr.getCodigoproducto());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando registro");
        }
    }

}
