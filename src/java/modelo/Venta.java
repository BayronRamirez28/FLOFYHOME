package modelo;

import java.sql.Date;

public class Venta {
    private int codigoventa, codigovendedor, codigopedido, codigodireccion;
    private Date fecha;
    private float subtotal, total;
    private Pedido pedido;
    private Usuario vendedor;
    private Direccion direccion;

    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public int getCodigovendedor() {
        return codigovendedor;
    }

    public void setCodigovendedor(int codigovendedor) {
        this.codigovendedor = codigovendedor;
    }

    public int getCodigopedido() {
        return codigopedido;
    }

    public void setCodigopedido(int codigopedido) {
        this.codigopedido = codigopedido;
    }

    public int getCodigodireccion() {
        return codigodireccion;
    }

    public void setCodigodireccion(int codigodireccion) {
        this.codigodireccion = codigodireccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
