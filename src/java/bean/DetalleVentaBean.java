package bean;

import dao.DetalleVentaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.DetalleVenta;

@ManagedBean
@ViewScoped
public class DetalleVentaBean {

    private DetalleVenta dv = new DetalleVenta();
    private List<DetalleVenta> lstDetalleVentas;
    private List<DetalleVenta> lstDetalleVentasFiltradas;
    private DetalleVentaDAO detalleventadao = new DetalleVentaDAO();

    public DetalleVenta getDv() {
        return dv;
    }

    public void setDv(DetalleVenta dv) {
        this.dv = dv;
    }

    public List<DetalleVenta> getLstDetalleVentas() {
        return lstDetalleVentas;
    }

    public void setLstDetalleVentas(List<DetalleVenta> lstDetalleVentas) {
        this.lstDetalleVentas = lstDetalleVentas;
    }

    public List<DetalleVenta> getLstDetalleVentasFiltradas() {
        return lstDetalleVentasFiltradas;
    }

    public void setLstDetalleVentasFiltradas(List<DetalleVenta> lstDetalleVentasFiltradas) {
        this.lstDetalleVentasFiltradas = lstDetalleVentasFiltradas;
    }
    
    public void listar(){
        lstDetalleVentas = detalleventadao.listar();
    }
    
    public void buscar (DetalleVenta dv){
        DetalleVenta temp = detalleventadao.buscar(dv);
        
        if (temp != null){
            dv = temp;
        }
    }
}
