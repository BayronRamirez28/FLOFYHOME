package modelo;

public class Direccion {
    private int codigodireccion, codigousuario;
    private String Direccion;
    private Usuario usuario;

    public int getCodigodireccion() {
        return codigodireccion;
    }

    public void setCodigodireccion(int codigodireccion) {
        this.codigodireccion = codigodireccion;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
