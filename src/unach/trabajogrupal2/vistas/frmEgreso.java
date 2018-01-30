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

public class frmEgreso extends JFrame{
    JLabel lblTitulo0;
    JLabel lblCodigoeg;
    JLabel lblCliente;
    JLabel lblValor;
    JLabel lblDetalle;
    
    JTextField txtCodigoeg;
    JTextField txtCliente;
    JTextField txtValor;
    JTextField txtDetalle;
    
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JButton btnlistar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public frmEgreso() {
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(2,3,5,5));
        
        lblTitulo0 = new JLabel("Datos egreso");
        
        lblCodigoeg= new JLabel("Codigo: ");
        lblCliente= new JLabel("Cliente:");
        lblValor= new JLabel("Valor :");
        lblDetalle= new JLabel("Detalle :");
       
        
        txtCodigoeg = new JTextField(2);
        txtCliente= new JTextField(2);
        txtValor= new JTextField(2);
        txtDetalle = new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        btnlistar=new JButton("Listar");
        
        pnlCentral.add(lblCodigoeg);
        pnlCentral.add(txtCodigoeg);
        pnlCentral.add(lblCliente);
        pnlCentral.add(txtCliente);
        pnlCentral.add(lblValor);
        pnlCentral.add(txtValor);
        pnlCentral.add(lblDetalle);
        pnlCentral.add(txtDetalle);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        pnlPie.add(btnlistar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        frmEgreso frmProfe= new frmEgreso();
        frmProfe.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this, "Proceso Correcto "," Transaccion", JOptionPane.INFORMATION_MESSAGE);
    }
    }
