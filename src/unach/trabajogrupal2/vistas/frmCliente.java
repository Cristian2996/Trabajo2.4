package unach.trabajogrupal2.vistas;

import unach.trabajogrupal2.entidades.*;
import unach.trabajogrupal2.dao.*;
import unach.trabajogrupal2.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class frmCliente extends JFrame {

    JLabel titulo;
    JLabel codigocl;
    JLabel nombres;
    JLabel apellidos;
    JLabel cedula;

    JTextField txttitulo1;
    JTextField txttitulo;
    JTextField txttitulo2;
    JTextField txtcodigocl;
    JTextField txtnombres;
    JTextField txtapellidos;
    JTextField txtcedula;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlcentral;
    JPanel pnlpie;

    public frmCliente() {
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(12, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));

        titulo = new JLabel("                                             DATOS DEL DOCENTE..   ");
        codigocl = new JLabel("CODIGO: ");
        txtcodigocl = new JTextField(2);
        nombres = new JLabel("NOMBRE: ");
        txtnombres = new JTextField(2);
        apellidos = new JLabel("APELLIDO: ");
        txtapellidos = new JTextField(2);
        cedula = new JLabel("CEDULA: ");
        txtcedula = new JTextField(2);

        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");

        this.add(titulo, BorderLayout.NORTH);

        pnlcentral.add(titulo);
        pnlcentral.add(codigocl);
        pnlcentral.add(txtcodigocl);
        pnlcentral.add(nombres);
        pnlcentral.add(txtnombres);
        pnlcentral.add(apellidos);
        pnlcentral.add(txtapellidos);
        pnlcentral.add(cedula);
        pnlcentral.add(txtcedula);

        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {

        frmCliente frmMenu2 = new frmCliente();
        frmMenu2.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {
//        IDocente docenteDao =new DocenteImpl;
//        

        JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
    }
}
