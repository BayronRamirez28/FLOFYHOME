package bean;

import dao.CategoriaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;


@ManagedBean
@ViewScoped
public class CategoriaBean {
    private Categoria cate = new Categoria();
    private List<Categoria> lstCates;
    private List<Categoria> lstCatesFiltrada;
    CategoriaDAO catedao = new CategoriaDAO();

    public Categoria getCate() {
        return cate;
    }

    public void setCate(Categoria cate) {
        this.cate = cate;
    }

    public List<Categoria> getLstCates() {
        return lstCates;
    }

    public void setLstCates(List<Categoria> lstCates) {
        this.lstCates = lstCates;
    }

    public List<Categoria> getLstCatesFiltrada() {
        return lstCatesFiltrada;
    }

    public void setLstCatesFiltrada(List<Categoria> lstCatesFiltrada) {
        this.lstCatesFiltrada = lstCatesFiltrada;
    }
    
    public void listar(){
        lstCates = catedao.listar();
    }
    
    public void buscar (Categoria c){
        Categoria temp = catedao.buscar(c);
        
        if(temp != null){
            cate = temp;
        }
    }
}
