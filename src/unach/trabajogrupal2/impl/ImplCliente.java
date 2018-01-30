package unach.trabajogrupal2.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import unach.trabajogrupal2.accesodatos.Conexion;
import unach.trabajogrupal2.accesodatos.Parametro;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.entidades.Cliente;

public class ImplCliente implements ICliente {

    @Override
    public int insertar(Cliente cliente) throws Exception {
      int nFilas=0;
        String csql = "Insert into Cliente (codigocl, nombre, apellido, cedula) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, cliente.getCodigocl()));
        lstP.add(new Parametro(2, cliente.getNombre()));
        lstP.add(new Parametro(3, cliente.getApellido()));
        lstP.add(new Parametro(4, cliente.getCedula()));
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
    public Cliente obtener(int codigocl) throws Exception {
     Cliente cli = null;
        String csql = "Select codigocl, nombre, apellido, cedula  From Cliente Where codigocl=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigocl));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                cli=new Cliente();
                cli.setCodigocl(rst.getInt(1));
                cli.setNombre(rst.getString(2));
                cli.setApellido(rst.getString(3));
                cli.setCedula(rst.getString(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return cli;
       
    }

    @Override
    public List<Cliente> obtener() throws Exception {
    ArrayList<Cliente> clie = new ArrayList<>();
        String csql="select codigocl, nombre, apellido, cedula from Cliente";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Cliente cli=null;
            while(rst.next()){
                cli=new Cliente();
                cli.setCodigocl(rst.getInt(1));
                cli.setNombre(rst.getString(2));
                cli.setApellido(rst.getString(3));
                cli.setCedula(rst.getString(4));
                clie.add(cli);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return clie;    
    }
    
}
