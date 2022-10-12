package bean;

import dao.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private List<Usuario> lstUsuarios;
    private List<Usuario> lstUsuariosFiltrada;
    private UsuarioDAO usudao = new UsuarioDAO();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Usuario> getLstUsuariosFiltrada() {
        return lstUsuariosFiltrada;
    }

    public void setLstUsuariosFiltrada(List<Usuario> lstUsuariosFiltrada) {
        this.lstUsuariosFiltrada = lstUsuariosFiltrada;
    }

   public void listar(){
       lstUsuarios = usudao.listar();
   }
    
   public void agregar(){
       usudao.agregar(usuario);
       limpiar();
   }
   
   public void buscar(Usuario u){
       Usuario temp = usudao.buscar(u);
       
       if(temp != null){
           usuario = temp;
       }
   }
   
   public void actualizar(){
       usudao.actualizar(usuario);
       limpiar();
   }
   
   public void limpiar(){
       usuario.setCodigousuario(0);
       usuario.setNombreusuario("");
       usuario.setTipodocumento("");
       usuario.setDni("");
       usuario.setContraseña("");
       usuario.setEmail("");
       usuario.setTelefono("");
       usuario.setCodigorol(0);
   }
}
