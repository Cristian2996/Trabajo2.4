package unach.trabajogrupal2.entidades;
public class Ingreso {
private int codigoin;
private Cliente cliente;
private int valor;
private String detalle; 

    public Ingreso() {
    }

    public Ingreso(int codigoin, Cliente cliente, int valor, String detalle) {
        this.codigoin = codigoin;
        this.cliente = cliente;
        this.valor = valor;
        this.detalle = detalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigoin() {
        return codigoin;
    }

    public void setCodigoin(int codigoin) {
        this.codigoin = codigoin;
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