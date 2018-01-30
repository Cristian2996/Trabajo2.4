package unach.trabajogrupal2;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.dao.IEgreso;
import unach.trabajogrupal2.entidades.*;
import unach.trabajogrupal2.impl.ImplCliente;
import unach.trabajogrupal2.impl.ImplEgreso;


public class testEgreso {
     public testEgreso() {
    }
   @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IEgreso egresoDao = new ImplEgreso();
        ICliente clienteDao = new ImplCliente();
        Cliente cliente = clienteDao.obtener(8);
        Egreso egreso = new Egreso(1315,cliente, 2110, "Sueldo");
        try{
            filasAfectadas = egresoDao.insertar(egreso);
            System.out.println("Egreso ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Egreso> lista = new ArrayList<>();
        try {
            lista = egresoDao.obtener();
            for (Egreso c:lista){
                System.out.println("---Datos Egreso---");
                System.out.println("Codigo Egreso :"+c.getCodigoeg());
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
