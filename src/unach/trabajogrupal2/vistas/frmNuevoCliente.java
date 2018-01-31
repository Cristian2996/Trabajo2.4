package unach.trabajogrupal2.vistas;

import unach.trabajogrupal2.entidades.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import unach.trabajogrupal2.dao.*;
import unach.trabajogrupal2.impl.*;
import unach.trabajogrupal2.entidades.*;
import java.util.List;

public class frmNuevoCliente extends JInternalFrame {

    JLabel lblCodigo;
    JLabel lblCedula;
    JLabel lblNombres;
    JLabel lblApellidos;
    JLabel lblTitulo0;

    JTextField txtCodigo;
    JTextField txtCedula;
    JTextField txtNombres;
    JTextField txtApellidos;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public frmNuevoCliente() {
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo0 = new JLabel("Datos Cliente");

        lblCodigo = new JLabel("Código:");
        lblCedula = new JLabel("Cédula:");
        lblNombres = new JLabel("Nombres:");
        lblApellidos = new JLabel("Apellidos:");

        txtCodigo = new JTextField(2);
        txtCedula = new JTextField(2);
        txtNombres = new JTextField(2);
        txtApellidos = new JTextField(2);

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);

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

        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        frmNuevoCliente frmMenu = new frmNuevoCliente();
        frmMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {
        Cliente cliente = new Cliente();
        ICliente clienteDao = new ImplCliente();
        cliente.setCodigocl(Integer.parseInt(txtCodigo.getText()));
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombres.getText());
        cliente.setApellido(txtApellidos.getText());
        
        try {
            if (clienteDao.insertar(cliente) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error desconocido: ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error desconocido: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
