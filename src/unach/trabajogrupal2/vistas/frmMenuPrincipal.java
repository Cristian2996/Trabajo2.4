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
        mniNuevoIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoIngresoActionPerformed(e);
            }
        });
        mniModificaIngreso = new JMenuItem("Modifica");
        mniEliminaIngreso = new JMenuItem("Elimina");
        mniBuscaIngreso = new JMenuItem("Busca");
        mniListaIngreso = new JMenuItem("Lista");
        
        mniListaIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaIngresoActionPerdormed(e);
            }
        });

        mniNuevoEgreso = new JMenuItem("Nuevo");
        mniNuevoEgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEgresoActionPerformed(e);
            }
        });
        mniModificaEgreso = new JMenuItem("Modifica");
        mniEliminaEgreso = new JMenuItem("Elimina");
        mniBuscaEgreso = new JMenuItem("Busca");
        mniListaEgreso = new JMenuItem("Lista");
        mniListaEgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaEgresoActionPerdormed(e);
            }
        });
        
        mniNuevoCliente = new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
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

    public void mniNuevoIngresoActionPerformed(ActionEvent e) {
        frmNuevoIngreso frm = new frmNuevoIngreso();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

    public void mniNuevoEgresoActionPerformed(ActionEvent e) {
        frmNuevoEgreso frm = new frmNuevoEgreso();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
//
    public void mniNuevoClienteActionPerformed(ActionEvent e) {
        frmNuevoCliente frm = new frmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    

    public void mniListaEgresoActionPerdormed(ActionEvent e)
    {
        frmListaEgreso frm = new frmListaEgreso();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaIngresoActionPerdormed(ActionEvent e)
    {
        frmListaIngreso frm = new frmListaIngreso();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public static void main(String[] args) {
        frmMenuPrincipal frmMEnu = new frmMenuPrincipal();
        frmMEnu.setVisible(true);

    }
}
