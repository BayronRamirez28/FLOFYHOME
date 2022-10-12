package bean;

import dao.LoteDAO;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Lote;

@ManagedBean
@ViewScoped
public class LoteBean {
    
    private Lote lot = new Lote();
    private List<Lote> lstLotes;
    private List<Lote> lstLotesFiltrada;
    private LoteDAO lotedao = new LoteDAO();

    public Lote getLot() {
        return lot;
    }

    public void setLot(Lote lot) {
        this.lot = lot;
    }

    public List<Lote> getLstLotes() {
        return lstLotes;
    }

    public void setLstLotes(List<Lote> lstLotes) {
        this.lstLotes = lstLotes;
    }

    public List<Lote> getLstLotesFiltrada() {
        return lstLotesFiltrada;
    }

    public void setLstLotesFiltrada(List<Lote> lstLotesFiltrada) {
        this.lstLotesFiltrada = lstLotesFiltrada;
    }
    
    public void listar(){
        lstLotes = lotedao.listar();
    }
    
    public void agregar(){
        lotedao.agregar(lot);
        limpiar();
    }
    
    public void buscar(Lote l){
        Lote temp = lotedao.buscar(l);
        
        if (temp != null){
            lot = temp;
        }
    }
    
    public void actualizar(){
        lotedao.actualizar(lot);
        limpiar();
    }
    
    public void eliminar(Lote l){
        lotedao.eliminar(l);
        limpiar();
    }
    
    public void limpiar(){
        lot.setCodigolote(0);
        lot.setCantidad(0);
        lot.setCodigoproducto(0);
        
    }

}
