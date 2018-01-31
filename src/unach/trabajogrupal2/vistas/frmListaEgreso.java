package unach.trabajogrupal2.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import unach.trabajogrupal2.dao.IEgreso;
import unach.trabajogrupal2.entidades.Egreso;
import unach.trabajogrupal2.impl.ImplEgreso;

public class frmListaEgreso extends JInternalFrame {
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    public frmListaEgreso(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        
        lblTitulo = new JLabel("Listado de Ingresos");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }    
    public void cargarTabla(){
        //modelo de datos de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Valor ");
        modelo.addColumn("Detalle");
        List<Egreso> lista = new ArrayList<>();
        try{
            IEgreso egresoDao = new ImplEgreso();
            lista = egresoDao.obtener();
        
        }catch (Exception e){
        
        JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                JOptionPane.ERROR_MESSAGE);
        }
        for(Egreso est : lista){
            modelo.addRow(new Object[]{est.getCodigoeg(),est.getCliente(), est.getValor(),
            est.getDetalle()});
        }
        tabla.setModel(modelo);
    }
}