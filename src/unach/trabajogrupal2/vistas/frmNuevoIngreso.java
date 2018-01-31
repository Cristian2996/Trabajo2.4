/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unach.trabajogrupal2.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.dao.IIngreso;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.entidades.Ingreso;
import unach.trabajogrupal2.impl.ImplCliente;
import unach.trabajogrupal2.impl.ImplIngreso;

public class frmNuevoIngreso extends JInternalFrame {

    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    JLabel titulo;
    JLabel codigoin;
    JLabel cliente;
    JLabel valor;
    JLabel detalle;

    JTextField txtcodigoin;
    JTextField txtvalor;
    JTextField txtdetalle;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public frmNuevoIngreso() {
        this.setSize(200, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        titulo = new JLabel("Ingreso");

        codigoin = new JLabel("Codigo: ");
        cliente = new JLabel("Cliente:");
        valor = new JLabel("Valor :");
        detalle = new JLabel("Detalle :");

        txtcodigoin = new JTextField(2);
        txtvalor = new JTextField(2);
        txtdetalle = new JTextField(2);
        cargarCliente();
        cmbCliente = new JComboBox(lstCliente.toArray());

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(codigoin);
        pnlCentral.add(txtcodigoin);
        pnlCentral.add(cliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(valor);
        pnlCentral.add(txtvalor);
        pnlCentral.add(detalle);
        pnlCentral.add(txtdetalle);
        

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });

        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);

        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        frmNuevoEgreso frmProfe = new frmNuevoEgreso();
        frmProfe.setVisible(true);
    }

    public void cargarCliente() {
        ICliente clienteDao = new ImplCliente();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los clientes!!",
                    "Error" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IIngreso ingresoDao = new ImplIngreso();
        Ingreso ingreso = new Ingreso();
        ingreso.setCliente((Cliente) cmbCliente.getSelectedItem());
        ingreso.setCodigoin(Integer.parseInt(txtcodigoin.getText()));
        ingreso.setValor(Integer.parseInt(txtvalor.getText()));
        ingreso.setDetalle(txtdetalle.getText());

        try {

            if (ingresoDao.insertar(ingreso) > 0) {
                JOptionPane.showMessageDialog(this, "Guardado Correctamente!!",
                        "Transaccion", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "Error desconocido!!",
                        "error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar!!",
                    "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

}
