package unach.trabajogrupal2.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import unach.trabajogrupal2.accesodatos.Conexion;
import unach.trabajogrupal2.accesodatos.Parametro;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.dao.IIngreso;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.entidades.Ingreso;

public class ImplIngreso implements IIngreso {

    @Override
    public int insertar(Ingreso ingreso) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Ingreso (codigoin, codigocl, valor, detalle) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, ingreso.getCodigoin()));
        lstP.add(new Parametro(2, ingreso.getCliente().getCodigocl()));
        lstP.add(new Parametro(3, ingreso.getValor()));
        lstP.add(new Parametro(4, ingreso.getDetalle()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Ingreso obtener(int codigoin) throws Exception {
//        Ingreso ing = null;
//        Cliente cliente = null;
//        ICliente clienteDao = new ImplCliente();
//        String csql = "Select codigoin, codCliente, valor, detalle From Ingreso Where codigoin=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, codigoin));
//        Conexion con = null;
//        try {
//            con = new Conexion();
//            ResultSet rst = con.ejecutarQuery(csql, lstPar);
//            while (rst.next()) {
//                cliente = new Cliente();
//                cliente = clienteDao.obtener(rst.getInt(2));
//                ing = new Ingreso();
//                ing.setCodigoin(rst.getInt(1));
//                ing.setCliente(cliente);
//                ing.setValor(rst.getInt(3));
//                ing.setDetalle(rst.getString(4));
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
//        } finally {
//            if (con != null) {
//                con.desconectar();
//            }
//        }
        return null;
    }

    @Override
    public List<Ingreso> obtener() throws Exception {
        ArrayList<Ingreso> ingresos = new ArrayList<>();
        Cliente cliente=null;
        ICliente clienteDao=new ImplCliente();
        String csql = "Select codigoin, codigocl, valor, detalle From Ingreso";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Ingreso ing=null;
            while(rst.next()){
                cliente=new Cliente();
                cliente=clienteDao.obtener(rst.getInt(2));
                ing=new Ingreso();
                ing.setCodigoin(rst.getInt(1));
                ing.setCliente(cliente);
                ing.setValor(rst.getInt(3));
                ing.setDetalle(rst.getString(4));
                ingresos.add(ing);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return ingresos;
    }

}
