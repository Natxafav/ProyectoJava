package Controler.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;
import view.com.company.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ControllerEntrada implements ActionListener,  WindowListener {

    private final ViewPanelEntrada frEntrada = new ViewPanelEntrada();
    private final ViewPersonas frPersonas=new ViewPersonas();
    private final DefaultTableModel m = null;
    // Constructor lanza cada uno de los procedimientos de la aplicación.
    public ControllerEntrada() {
        System.out.println("ControllerEntrada Constructor");
        iniciarVentana();
        iniciarEventos();
    }
    public void iniciarVentana() {
        System.out.println("frEntrada.setVisible(true); en controlador de entrada");
        frEntrada.setVisible(true);
    }
    public void iniciarEventos() {
        System.out.println("Dentro de iniciarEventos en ControllerEntrada");
        frEntrada.getBtnSalir().addActionListener(this::actionPerformed);
        frEntrada.getAsignaturasButton().addActionListener(this::actionPerformed);
        frEntrada.getPersonasButton().addActionListener(this::actionPerformed);
        frEntrada.addWindowListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String entrada = e.getActionCommand();
        switch (entrada) {
            case "Salir":
                System.out.println("Ha salido del programa con el boton salir del controllerEntrada");
                System.exit(0);
                break;

            case "Asignaturas":
                ControllerAsignaturas contrAsig = new ControllerAsignaturas();
                System.out.println("contrAsig.mostrarVistaAsignaturas(); en ActLIst de ContrEntr");
                frEntrada.dispose();
                break;

            case "Personas":
                System.out.println("controlador entrada al pulsar personas");
                frPersonas.setVisible(true);
                ModelPersonas persona = new ModelPersonas();
                frPersonas.getTable1().setModel(persona.CargaDatos(m));
                break;
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ha salido del programa con exit on close.");
        frEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConectionBD.closeConn();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
