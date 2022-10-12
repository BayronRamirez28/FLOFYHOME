package bean;

import dao.DetallePedidoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.DetallePedido;

@ManagedBean
@ViewScoped
public class DetallePedidoBean {
    
    private DetallePedido depe = new DetallePedido();
    private List<DetallePedido> lstDetallePedidos;
    private List<DetallePedido> lstDetallePedidosFiltrada;
    private DetallePedidoDAO detallepedidodao = new DetallePedidoDAO();

    public DetallePedido getDepe() {
        return depe;
    }

    public void setDepe(DetallePedido depe) {
        this.depe = depe;
    }

    public List<DetallePedido> getLstDetallePedidos() {
        return lstDetallePedidos;
    }

    public void setLstDetallePedidos(List<DetallePedido> lstDetallePedidos) {
        this.lstDetallePedidos = lstDetallePedidos;
    }

    public List<DetallePedido> getLstDetallePedidosFiltrada() {
        return lstDetallePedidosFiltrada;
    }

    public void setLstDetallePedidosFiltrada(List<DetallePedido> lstDetallePedidosFiltrada) {
        this.lstDetallePedidosFiltrada = lstDetallePedidosFiltrada;
    }

    public void listar(){
        lstDetallePedidos = detallepedidodao.listar();
    }
    
    public void buscar (DetallePedido depe){
        DetallePedido temp = detallepedidodao.buscar(depe);
        
        if(temp != null){
           depe = temp;
        }
    }
}
