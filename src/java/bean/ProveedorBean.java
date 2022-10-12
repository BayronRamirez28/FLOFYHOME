package bean;

import dao.ProveedorDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Proveedor;


@ManagedBean
@ViewScoped
public class ProveedorBean {
    private Proveedor prov = new Proveedor();
    private List<Proveedor> lstProvs;
    private List<Proveedor> lstProvsFilstrada;
    ProveedorDAO provdao = new ProveedorDAO();

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public List<Proveedor> getLstProvs() {
        return lstProvs;
    }

    public void setLstProvs(List<Proveedor> lstProvs) {
        this.lstProvs = lstProvs;
    }

    public List<Proveedor> getLstProvsFilstrada() {
        return lstProvsFilstrada;
    }

    public void setLstProvsFilstrada(List<Proveedor> lstProvsFilstrada) {
        this.lstProvsFilstrada = lstProvsFilstrada;
    }

    public void listar(){
        lstProvs = provdao.listar();
    }
    
    public void agregar(){
        provdao.agregar(prov);
        limpiar();
    }
    
    public void buscar(Proveedor p){
        Proveedor temp = provdao.buscar(p);
        
        if(temp != null){
            prov = temp;
        }
    }
    
    public void actualizar(){
        provdao.actualizar(prov);
        limpiar();
    }
    
    public void eliminar(Proveedor p){
        provdao.eliminar(p);
        limpiar();
    }
    
    public void limpiar(){
        prov.setCodigoproveedor(0);
        prov.setNombreproveedor("");
        prov.setEmail("");
        prov.setTelefono("");
    }
    
}
