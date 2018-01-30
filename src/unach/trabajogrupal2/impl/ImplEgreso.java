package unach.trabajogrupal2.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import unach.trabajogrupal2.accesodatos.Conexion;
import unach.trabajogrupal2.accesodatos.Parametro;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.dao.IEgreso;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.entidades.Egreso;

public class ImplEgreso implements IEgreso {

    @Override
    public int insertar(Egreso egreso) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Egreso (Codigoeg, codigocl, valor, detalle) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, egreso.getCodigoeg()));
        lstP.add(new Parametro(2, egreso.getCliente().getCodigocl()));
        lstP.add(new Parametro(3, egreso.getValor()));
        lstP.add(new Parametro(4, egreso.getDetalle()));
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
    public Egreso obtener(int codigoeg) throws Exception {
//        Egreso egr = null;
//        Cliente cliente = null;
//        ICliente clienteDao = new ImplCliente();
//        String csql = "Select codigoeg, codCliente, valor, detalle From Egreso Where codigoeg=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, codigoeg));
//        Conexion con = null;
//        try {
//            con = new Conexion();
//            ResultSet rst = con.ejecutarQuery(csql, lstPar);
//            while (rst.next()) {
//                cliente = new Cliente();
//                cliente = clienteDao.obtener(rst.getInt(2));
//                egr = new Egreso();
//                egr.setCodigoeg(rst.getInt(1));
//                egr.setCliente(cliente);
//                egr.setValor(rst.getInt(3));
//                egr.setDetalle(rst.getString(4));
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
    public List<Egreso> obtener() throws Exception {
      ArrayList<Egreso> egresos = new ArrayList<>();
        Cliente cliente=null;
        ICliente clienteDao=new ImplCliente();
        String csql = "Select codigoeg, codigocl, valor, detalle From Egreso";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Egreso egr=null;
            while(rst.next()){
                cliente=new Cliente();
                cliente=clienteDao.obtener(rst.getInt(2));
                egr=new Egreso();
                egr.setCodigoeg(rst.getInt(1));
                egr.setCliente(cliente);
                egr.setValor(rst.getInt(3));
                egr.setDetalle(rst.getString(4));
                egresos.add(egr);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return egresos;
    }

}
