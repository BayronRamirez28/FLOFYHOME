package modelo;
import java.sql.Date;

public class Lote {
       private int codigolote, cantidad, codigoproducto;
       private Date fechalote, fechavencimiento;
       private Producto producto;

    public int getCodigolote() {
        return codigolote;
    }

    public void setCodigolote(int codigolote) {
        this.codigolote = codigolote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public Date getFechalote() {
        return fechalote;
    }

    public void setFechalote(Date fechalote) {
        this.fechalote = fechalote;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
       
       
       
}
