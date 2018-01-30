package unach.trabajogrupal2.dao;

import java.util.List;
import unach.trabajogrupal2.entidades.Ingreso;
public interface IIngreso {
    public int insertar(Ingreso ingreso) throws Exception;
    public Ingreso obtener(int codigoin) throws Exception;
    public List<Ingreso> obtener() throws Exception;   
}
