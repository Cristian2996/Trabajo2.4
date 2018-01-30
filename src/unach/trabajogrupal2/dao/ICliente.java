package unach.trabajogrupal2.dao;
import java.util.List;
import unach.trabajogrupal2.entidades.Cliente;
public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public Cliente obtener(int codigocl) throws Exception;
    public List<Cliente> obtener() throws Exception;
        
}
