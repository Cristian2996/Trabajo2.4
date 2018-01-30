package unach.trabajogrupal2;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.impl.ImplCliente;

public class testCliente {
    public testCliente() {
    }

    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        ICliente clienteDao = new ImplCliente();
        Cliente cliente = new Cliente(8,"Mario","Perez","060495279-6");
        try{
            filasAfectadas = clienteDao.insertar(cliente);
            System.out.println("Cliente ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
            for (Cliente c:lista){
            System.out.println("Datos cliente");
            System.out.println("Codigo  :"+c.getCodigocl());
            System.out.println("Nombre :"+c.getNombre());
            System.out.println("Apellido :"+c.getApellido());
            System.out.println("Cedula :"+c.getCedula());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}
