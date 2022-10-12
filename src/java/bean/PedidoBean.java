package bean;

import dao.PedidoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Pedido;

@ManagedBean
@ViewScoped
public class PedidoBean {
    
    private Pedido per = new Pedido();
    private List<Pedido> lstPedidos;
    private List<Pedido> lstPedidosFiltrada;
    private PedidoDAO pedidodao = new PedidoDAO();

    public Pedido getPer() {
        return per;
    }

    public void setPer(Pedido per) {
        this.per = per;
    }

    public List<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(List<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }

    public List<Pedido> getLstPedidosFiltrada() {
        return lstPedidosFiltrada;
    }

    public void setLstPedidosFiltrada(List<Pedido> lstPedidosFiltrada) {
        this.lstPedidosFiltrada = lstPedidosFiltrada;
    }
    
     public void listar(){
        lstPedidos = pedidodao.listar();
    }
     
     public void buscar(){
         Pedido temp = pedidodao.buscar(per);
         
         if(temp != null){
             per = temp;
         }
     }
}
