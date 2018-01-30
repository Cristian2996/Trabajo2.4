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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import unach.trabajogrupal2.dao.IIngreso;
import unach.trabajogrupal2.entidades.Ingreso;
import unach.trabajogrupal2.impl.ImplIngreso;

public class frmNuevoIngreso extends JInternalFrame{
    JLabel codigo;
    JLabel valor;
    JLabel detalle;
    
    JTextField txtcodigo;
    JTextField txtvalor;
    JTextField txtdetalle;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JButton btnlistar;
   
    JPanel pnlCentral;
    JPanel pnlPie;
    public frmNuevoIngreso() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        codigo= new JLabel("Codigo: ");
        valor= new JLabel("Valor:");
        detalle= new JLabel("Detalle :");
        
        txtcodigo = new JTextField(2);
        txtvalor= new JTextField(2);
        txtdetalle= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        btnlistar=new JButton("Listar");
        
        pnlCentral.add(codigo);
        pnlCentral.add(txtcodigo);
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
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });      
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        pnlPie.add(btnlistar);
        
        ///this.add(direccion, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);  
    }
     public static void main(String[] args) {
        frmNuevoIngreso frmIngre= new frmNuevoIngreso();
        frmIngre.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionListener e){
    IIngreso ingresoDao = new ImplIngreso();
    
    Ingreso ingreso = new Ingreso();
    ingreso.setCodigoin(Integer.parseInt( txtcodigo.getText()));
    ingreso.setValor(Integer.parseInt(txtvalor.getText()));
    ingreso.setDetalle(txtdetalle.getText());
   
    try{
    
        if(ingresoDao.insertar(ingreso)>0){
        JOptionPane.showMessageDialog(this,"Guardado Correctamente!!",
                "Transaccion", JOptionPane.INFORMATION_MESSAGE);
        }else {
        
    JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "error", JOptionPane.ERROR_MESSAGE);
    
    }}catch (Exception ex){
    JOptionPane.showMessageDialog(this,"Error al guardar!!",
                "Error", JOptionPane.INFORMATION_MESSAGE);

    }
    
    }
    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this,"Proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
    }
}
