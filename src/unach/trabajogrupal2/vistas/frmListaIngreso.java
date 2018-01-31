/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import unach.trabajogrupal2.dao.IIngreso;
import unach.trabajogrupal2.entidades.Ingreso;
import unach.trabajogrupal2.impl.ImplIngreso;

public class frmListaIngreso extends JInternalFrame {

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public frmListaIngreso() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado de Ingresos");
        tabla = new JTable();
        jscTabla = new JScrollPane(tabla);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();

    }

    public void cargarTabla() {
        //modelo de datos de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Cliente");
        modelo.addColumn("Valor ");
        modelo.addColumn("Detalle");
        List<Ingreso> lista = new ArrayList<>();
        try {
            IIngreso ingresoDao = new ImplIngreso();
            lista = ingresoDao.obtener();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Ingreso est : lista) {
            modelo.addRow(new Object[]{est.getCodigoin(),est.getCliente(), est.getValor(),
                est.getDetalle()});
        }
        
        tabla.setModel(modelo);
    }
}
