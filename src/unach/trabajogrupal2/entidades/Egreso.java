package unach.trabajogrupal2.entidades;

public class Egreso {

    private int codigoeg;
    Cliente cliente;
    private int valor;
    private String detalle;

    public Egreso() {
    }

    public Egreso(int codigoeg, Cliente cliente, int valor, String detalle) {
        this.codigoeg = codigoeg;
        this.cliente = cliente;
        this.valor = valor;
        this.detalle = detalle;
    }

    public int getCodigoeg() {
        return codigoeg;
    }

    public void setCodigoeg(int codigoeg) {
        this.codigoeg = codigoeg;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
