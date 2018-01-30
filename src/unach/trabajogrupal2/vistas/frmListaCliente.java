
package unach.trabajogrupal2.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.impl.ImplCliente;


public class frmListaCliente extends JInternalFrame {
    JLabel lbTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    

public frmListaCliente(){
    this.setSize(800,600);
    this.setLayout(new BorderLayuot());
    this.setClosable(true);
    
    
   lbTitulo = new JLabel("Listado de Clientes");
   tabla = new JTable();
   this.add(lbTitulo,BorderLayout.NORTH);
   this.add(tabla,BorderLayout.CENTER);
   cargarTabla();
   
  

}
public void cargarTabla(){

modelo= new  DefaultTableModel();
modelo.addColumn("Codigo");
modelo.addColumn("Cedula");
modelo.addColumn("Nombre");
modelo.addColumn("Apellido");
 List<Cliente>lista = new ArrayList<>();
 try{
     ICliente clienteDao= new ImplCliente();
     lista=clienteDao.obtener();
 }catch(Exception e){
     JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
 }
 for (Cliente cl : lista) {
     modelo.addRow(new Object[]{cl.getCodigocl(),cl.getNombre(),cl.getApellido(),cl.getCedula()});
     
 }
 tabla.setModel(modelo);
}
}
