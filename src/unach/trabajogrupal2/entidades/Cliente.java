package unach.trabajogrupal2.entidades;
public class Cliente {
private int codigocl;
private String nombre;
private String apellido;
private String cedula; 

    public Cliente() {
    }

    public Cliente(int codigocl, String nombre, String apellido, String cedula) {
        this.codigocl = codigocl;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public int getCodigocl() {
        return codigocl;
    }

    public void setCodigocl(int codigocl) {
        this.codigocl = codigocl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    @Override
    public String toString() {
        return cedula;
    }
}
