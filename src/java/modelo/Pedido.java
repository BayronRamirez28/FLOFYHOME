package modelo;

import java.sql.Date;

public class Pedido {
    private int codigopedido, codigocliente, codigodireccion;
    private Date fecha;
    private Usuario usuario;
    private Direccion direccion;

    public int getCodigopedido() {
        return codigopedido;
    }

    public void setCodigopedido(int codigopedido) {
        this.codigopedido = codigopedido;
    }

    public int getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
