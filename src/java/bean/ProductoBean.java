package bean;

import dao.ProductoDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import modelo.Producto;

@ManagedBean
@ViewScoped
public class ProductoBean {

    private Producto producto = new Producto();
    private List<Producto> lstProductos;
    private List<Producto> lstProductosFiltrada;
    private ProductoDAO prodao = new ProductoDAO();
    private Part imagen;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public List<Producto> getLstProductosFiltrada() {
        return lstProductosFiltrada;
    }

    public void setLstProductosFiltrada(List<Producto> lstProductosFiltrada) {
        this.lstProductosFiltrada = lstProductosFiltrada;
    }

    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }

    public void listar() {
        lstProductos = prodao.listar();

    }

    public void guardar() {
        try {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String ruta = ctx.getRealPath("/");

            InputStream is = imagen.getInputStream();
            File f = new File(ruta + "/imgPro", producto.getCodigoproducto() + ".jpg");

            f.createNewFile();
            FileOutputStream nf = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int tam;

            while ((tam = is.read(buffer)) > 0) {
                nf.write(buffer, 0, tam);
            }

            producto.setFoto(f.getName());

            nf.close();
            is.close();

        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error con imagen", "No se puede subir la Imagen"));
        }
        try {
            prodao.agregar(producto);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Crear Producto", "Producto agregado exitosamente"));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El Código del Producto ya existe"));
        }
    }

    public void buscar(Producto p) {
        Producto temp = prodao.buscar(p);

        if (temp != null) {
            producto = temp;
        }
    }

    public void actualizar() {
        if (imagen != null) {
            try {
                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String ruta = ctx.getRealPath("/");

                InputStream is = imagen.getInputStream();
                File f = new File(ruta + "/imgPro", producto.getCodigoproducto() + ".jpg");

                f.createNewFile();
                FileOutputStream nf = new FileOutputStream(f);

                byte[] buffer = new byte[1024];
                int tam;

                while ((tam = is.read(buffer)) > 0) {
                    nf.write(buffer, 0, tam);
                }

                producto.setFoto(f.getName());

                nf.close();
                is.close();
            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error con Imagen", "No se puede subir la Imagen"));
            }
            prodao.actualizar(producto);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editar Producto", "Producto actualizado exitosamente"));
        }
    }

    public void limpiar() {
        producto.setCodigoproducto(0);
        producto.setNombreproducto("");
        producto.setCantidad(0);
        producto.setPreciocompra(0);
        producto.setPrecioventa(0);
        producto.setEstado("");
        producto.setDetalle("");
        producto.setCantidadminima(0);
        producto.setFoto("");
        producto.setFoto_img("");
        producto.setCodigoproveedor(0);
        producto.setCodigocategoria(0);

    }

}
