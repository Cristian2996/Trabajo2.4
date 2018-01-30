package unach.trabajogrupal2.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class frmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JMenu mnIngreso;
    JMenuItem mniNuevoIngreso;
    JMenuItem mniModificaIngreso;
    JMenuItem mniEliminaIngreso;
    JMenuItem mniBuscaIngreso;
    JMenuItem mniListaIngreso;
    JMenu mnEgreso;
    JMenuItem mniNuevoEgreso;
    JMenuItem mniModificaEgreso;
    JMenuItem mniEliminaEgreso;
    JMenuItem mniBuscaEgreso;
    JMenuItem mniListaEgreso;
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    JDesktopPane dkpEscritorio;

    public frmMenuPrincipal() {
        dkpEscritorio = new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Secion");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnIngreso = new JMenu("Ingreso");
        mnEgreso = new JMenu("Egreso");
        mnCliente = new JMenu("Cliente");
        mniNuevoIngreso = new JMenuItem("Nuevo");
//        mniNuevoIngreso.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoIngresoActionPerformed(e);
//            }
//        });
        mniModificaIngreso = new JMenuItem("Modifica");
        mniEliminaIngreso = new JMenuItem("Elimina");
        mniBuscaIngreso = new JMenuItem("Busca");
        mniListaIngreso = new JMenuItem("Lista");
        
//        mniListaEstudiante.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniListaEstudianteActionPerdormed(e);
//            }
//        });

        mniNuevoEgreso = new JMenuItem("Nuevo");
//        mniNuevoEgreso.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniNuevoEgresoActionPerformed(e);
//            }
//        });
        mniModificaEgreso = new JMenuItem("Modifica");
        mniEliminaEgreso = new JMenuItem("Elimina");
        mniBuscaEgreso = new JMenuItem("Busca");
        mniListaEgreso = new JMenuItem("Lista");
        
        mniNuevoCliente = new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniClienteActionPerformed(e);
            }
        });
        mniModificaCliente = new JMenuItem("Modifica");
        mniEliminaCliente = new JMenuItem("Elimina");
        mniBuscaCliente = new JMenuItem("Busca");
        mniListaCliente = new JMenuItem("Lista");
        
//        mniListaDocente.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mniListaDocenteActionPerdormed(e);
//            }
//        });
        
        mnIngreso.add(mniNuevoIngreso);
        mnIngreso.add(mniModificaIngreso);
        mnIngreso.add(mniEliminaIngreso);
        mnIngreso.addSeparator();
        mnIngreso.add(mniBuscaIngreso);
        mnIngreso.add(mniListaIngreso);
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnIngreso);
        mnbPrincipal.add(mnEgreso);
        mnbPrincipal.add(mnCliente);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);

        mnEgreso.add(mniNuevoEgreso);
        mnEgreso.add(mniModificaEgreso);
        mnEgreso.add(mniEliminaEgreso);
        mnEgreso.addSeparator();
        mnEgreso.add(mniBuscaEgreso);
        mnEgreso.add(mniListaEgreso);

        mnCliente.add(mniNuevoCliente);
        mnCliente.add(mniModificaCliente);
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.add(mniListaCliente);
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mniSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }

//    public void mniNuevoEstudianteActionPerformed(ActionEvent e) {
//        frmNuevoEstudiante frm = new frmNuevoEstudiante();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//
//    public void mniNuevoCursoActionPerformed(ActionEvent e) {
//        frmNuevoCurso frm = new frmNuevoCurso();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//
    public void mniClienteActionPerformed(ActionEvent e) {
        frmCliente frm = new frmCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    

//    public void mniListaEstudianteActionPerdormed(ActionEvent e)
//    {
//        frmListaEstudiante frm = new frmListaEstudiante();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
//    public void mniListaDocenteActionPerdormed(ActionEvent e)
//    {
//        frmListaDocente frm = new frmListaDocente();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
//    }
    public static void main(String[] args) {
        frmMenuPrincipal frmMEnu = new frmMenuPrincipal();
        frmMEnu.setVisible(true);

    }
}
