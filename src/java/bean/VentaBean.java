package bean;

import dao.VentaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Venta;

@ManagedBean
@ViewScoped
public class VentaBean {

    private Venta ven = new Venta();
    private List<Venta> lstVentas;
    private List<Venta> lstVentasFiltrada;
    private VentaDAO ventadao = new VentaDAO();

    public Venta getVen() {
        return ven;
    }

    public void setVen(Venta ven) {
        this.ven = ven;
    }

    public List<Venta> getLstVentas() {
        return lstVentas;
    }

    public void setLstVentas(List<Venta> lstVentas) {
        this.lstVentas = lstVentas;
    }

    public List<Venta> getLstVentasFiltrada() {
        return lstVentasFiltrada;
    }

    public void setLstVentasFiltrada(List<Venta> lstVentasFiltrada) {
        this.lstVentasFiltrada = lstVentasFiltrada;
    }
    
    public void listar(){
        lstVentas = ventadao.listar();
    }
    
    public void buscar (Venta ven){
        Venta temp = ventadao.buscar(ven);
        
        if(temp != null){
            ven = temp;
        }
    }
            
}
