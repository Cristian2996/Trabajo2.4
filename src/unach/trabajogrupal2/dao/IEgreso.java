package unach.trabajogrupal2.dao;

import java.util.List;
import unach.trabajogrupal2.entidades.Egreso;
public interface IEgreso {
    public int insertar(Egreso egreso) throws Exception;
    public Egreso obtener(int codigoeg) throws Exception;
    public List<Egreso> obtener() throws Exception;
}

