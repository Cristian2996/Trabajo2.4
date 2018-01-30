package unach.trabajogrupal2;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.dao.IIngreso;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.entidades.Ingreso;
import unach.trabajogrupal2.impl.ImplCliente;
import unach.trabajogrupal2.impl.ImplIngreso;

public class testIngreso {
    public testIngreso() {
    }
    
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IIngreso ingresoDao = new ImplIngreso();
        ICliente clienteDao = new ImplCliente();
        Cliente cliente = clienteDao.obtener(8);
        Ingreso ingreso = new Ingreso(2315,cliente, 2100, "Quincena");
        try{
            filasAfectadas = ingresoDao.insertar(ingreso);
            System.out.println("Ingreso ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error::: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Ingreso> lista = new ArrayList<>();
        try {
            lista = ingresoDao.obtener();
            for (Ingreso c:lista){
                System.out.println("---Datos Ingreso---");
                System.out.println("Codigo Ingreso :"+c.getCodigoin());
                System.out.println("Codigo cliente :"+c.getCliente().getCodigocl());
                System.out.println("Valor  :"+c.getValor());
            System.out.println("Detalle :"+c.getDetalle());
            
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}
