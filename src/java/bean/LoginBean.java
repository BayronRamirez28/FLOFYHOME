package bean;

import dao.ConexionDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean
public class LoginBean {

    private Usuario us = new Usuario();

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void autenticar() {
        try {
            Connection con = ConexionDAO.conectar();

            String sql = "SELECT * FROM Usuario WHERE DNI = ? AND Contraseña = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getDni());
            ps.setString(2, us.getContraseña());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", rs.getString("Nombre_Usuario"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Rol", rs.getString("Codigo_Rol"));

                switch (rs.getString("Codigo_Rol")) {
                    case "1":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador/usuarios.xhtml");
                        break;
                    case "2": 
                        FacesContext.getCurrentInstance().getExternalContext().redirect("JefeInventario/productos.xhtml");
                        break;
                    case "3": 
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Vendedor/ventas.xhtml");
                        break;
                    case "4":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Cliente/pedidos.xhtml");
                        break;
                    
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Documento de Usuario y/o Contraseña no válidos"));
            }
        } catch (IOException | SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error accediendo a Base de Datos"));
        }
    }
    
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException e) {
        }
    }
    
     public void verifSesionAdmin() {
        String CodigoRol = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Rol");

        if (CodigoRol == null || CodigoRol.equals("2") || CodigoRol.equals("3") || CodigoRol.equals("4")) {
            try {                
                FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
            } catch (IOException e) {
            }
        }
    }
}
