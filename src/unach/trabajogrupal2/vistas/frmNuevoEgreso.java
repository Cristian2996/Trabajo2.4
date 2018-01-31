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
import java.util.List;
import javax.swing.*;
import unach.trabajogrupal2.dao.ICliente;
import unach.trabajogrupal2.impl.ImplCliente;

public class frmNuevoEgreso extends JInternalFrame {

    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    JLabel titulo;
    JLabel codigoeg;
    JLabel cliente;
    JLabel valor;
    JLabel detalle;

    JTextField txtcodigoeg;
    JTextField txtvalor;
    JTextField txtdetalle;

    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlCentral;
    JPanel pnlPie;

    public frmNuevoEgreso() {
        this.setSize(200, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral = new JPanel();
        pnlPie = new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1, 2, 5, 5));

        titulo = new JLabel("Egreso");
        codigoeg = new JLabel("Codigo: ");
        cliente= new JLabel("Cliente:");
        valor = new JLabel("Valor :");
        detalle = new JLabel("Detalle :");
        
        txtcodigoeg = new JTextField(2);
        txtvalor = new JTextField(2);
        txtdetalle = new JTextField(2);
        cargarCliente();
        cmbCliente= new JComboBox(lstCliente.toArray());

        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");

        pnlCentral.add(codigoeg);
        pnlCentral.add(txtcodigoeg);
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
    public void cargarCliente(){
        ICliente clienteDao = new ImplCliente();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los clientes!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void btnAceptarActionListener(ActionEvent e) {
        IEgreso egresoDao = new ImplEgreso();
        Egreso egreso = new Egreso();
        egreso.setCliente((Cliente) cmbCliente.getSelectedItem());
        egreso.setCodigoeg(Integer.parseInt(txtcodigoeg.getText()));
        egreso.setValor(Integer.parseInt(txtvalor.getText()));
        egreso.setDetalle(txtdetalle.getText());

        try {
            if (egresoDao.insertar(egreso) > 0) {
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
