package unach.trabajogrupal2.vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class frmMenuPrincipal extends JFrame {
JLabel lblTitulo0;
JLabel lblTitulo1;
JLabel lblTitulo2;
JLabel lblTitulo3;
JLabel lblGenero;
JTextField txtTitulo0;
JTextField txtTitulo1;
JTextField txtTitulo2;
JTextField txtTitulo3;
JComboBox cmbGenero;
JButton btnLimpiar;
JButton btnAceptar;

JPanel pnlCentral;
JPanel pnlPie;
    public frmMenuPrincipal() {
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
        pnlCentral=new JPanel();
        pnlPie=new JPanel();
        pnlCentral.setLayout(new GridLayout(4,2,5,5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0=new JLabel("Datos Estudiante");
        
        lblTitulo1=new JLabel("Etiqueta1");
        lblTitulo2=new JLabel("Etiqueta2");
        lblTitulo3=new JLabel("Etiqueta3");
        lblGenero= new JLabel("Genero");
        txtTitulo1=new JTextField(2);
        txtTitulo2=new JTextField(2);
        txtTitulo3=new JTextField(2);
        cmbGenero=new JComboBox(new String[]{"Masculino","Femenino"});
        btnLimpiar=new JButton("Limpiar");
        btnAceptar=new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo2);
        pnlCentral.add(lblTitulo3);
        pnlCentral.add(txtTitulo3);
        pnlCentral.add(lblGenero);
        pnlCentral.add(cmbGenero);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnAceptarActionListener(e);
                }catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                }
            }
        });
      
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        this.add(lblTitulo0,BorderLayout.NORTH);
        this.add(pnlCentral,BorderLayout.CENTER);
        this.add(pnlPie,BorderLayout.SOUTH);
    }
public static void main(String[] args){
    frmMenuPrincipal frmMenu = new frmMenuPrincipal();
    frmMenu.setVisible(true);
}
public void btnAceptarActionListener(ActionEvent e){
    JOptionPane.showMessageDialog(this, "Proceso correcto!", "Transaccion",JOptionPane.INFORMATION_MESSAGE);
}
}
