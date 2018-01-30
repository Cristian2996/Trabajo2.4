package unach.trabajogrupal2.vistas;

import unach.trabajogrupal2.dao.IEgreso;
import unach.trabajogrupal2.entidades.Egreso;
import unach.trabajogrupal2.entidades.Cliente;
import unach.trabajogrupal2.impl.ImplEgreso;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class frmNuevoEgreso extends JInternalFrame {

    JLabel titulo;
    JLabel codigoeg;
    JLabel cliente;
    JLabel valor;
    JLabel detalle;

    JTextField txtcodigoeg;
    JTextField txtcliente;
    JTextField txtvalor;
    JTextField txtdetalle;

    JButton btnLimpiar;
    JButton btnAceptar;
    JButton btnlistar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public frmNuevoEgreso() {
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        titulo = new JLabel("Egreso");

        codigoeg = new JLabel("Codigo: ");
        cliente = new JLabel("Cliente:");
        valor = new JLabel("Valor :");
        detalle = new JLabel("Detalle :");

        txtcodigoeg = new JTextField(2);
        txtcliente = new JTextField(2);
        txtvalor = new JTextField(2);
        txtdetalle = new JTextField(2);

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        btnlistar = new JButton("Listar");

        pnlCentral.add(codigoeg);
        pnlCentral.add(txtcodigoeg);
        pnlCentral.add(cliente);
        pnlCentral.add(txtcliente);
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
        pnlPie.add(btnlistar);

        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        frmNuevoEgreso frmProfe = new frmNuevoEgreso();
        frmProfe.setVisible(true);
    }

    public void btnAceptarActionListener(ActionListener e) {
        IEgreso egresoDao = new ImplEgreso();
        Egreso egreso = new Egreso();
        egreso.setCodigoeg(Integer.parseInt(txtcodigoeg.getText()));
        egreso.setValor(Integer.parseInt(txtvalor.getText()));
        egreso.setDetalle(txtdetalle.getText());

        try {

            if (egresoDao.insertar(egreso) > 0) {
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

    public void btnAceptarActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);

    }

}
