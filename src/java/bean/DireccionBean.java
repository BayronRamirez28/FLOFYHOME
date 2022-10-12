package bean;

import dao.DireccionDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Direccion;


@ManagedBean
@ViewScoped
public class DireccionBean {
    
    private Direccion dir = new Direccion();
    private List<Direccion> lstDirecciones;
    private List<Direccion> lstDireccionesFiltrada;
    private DireccionDAO direcciondao = new DireccionDAO();

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public List<Direccion> getLstDirecciones() {
        return lstDirecciones;
    }

    public void setLstDirecciones(List<Direccion> lstDirecciones) {
        this.lstDirecciones = lstDirecciones;
    }

    public List<Direccion> getLstDireccionesFiltrada() {
        return lstDireccionesFiltrada;
    }

    public void setLstDireccionesFiltrada(List<Direccion> lstDireccionesFiltrada) {
        this.lstDireccionesFiltrada = lstDireccionesFiltrada;
    }
    
    public void listar(){
        lstDirecciones = direcciondao.listar();
    }
    
    public void buscar (Direccion dir){
        Direccion temp = direcciondao.buscar(dir);
        
        if(temp != null){
            dir = temp;
        }
    }
    
}
