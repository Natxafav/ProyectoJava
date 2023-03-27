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
    private final ModelAsignaturas modelAsignaturas;
    private final ViewAsignaturas frAsignaturas;

    // Constructor lanza cada uno de los procedimientos de la aplicación.
    public ControllerEntrada(ModelAsignaturas modelAsignaturas, ViewAsignaturas frAsignaturas) {
        this.modelAsignaturas=modelAsignaturas;
        this.frAsignaturas=frAsignaturas;
        iniciarVentana();
        iniciarEventos();
    }
    public void iniciarVentana() {
         frEntrada.setVisible(true);
    }
    public void iniciarEventos() {
        frEntrada.getBtnSalir().addActionListener(this::actionPerformed);
        frEntrada.getAsignaturasButton().addActionListener(this::actionPerformed);
        frEntrada.getPersonasButton().addActionListener(this::actionPerformed);
        frEntrada.addWindowListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Según el botón pulsado, realiza una acción.
        String entrada = e.getActionCommand();
        switch (entrada) {
            case "Salir":
                System.out.println("Ha salido del programa.");
                System.exit(0);
                break;

            case "Asignaturas":
                ControllerAsignaturas contrAsig = new ControllerAsignaturas(modelAsignaturas, frAsignaturas);
                frEntrada.dispose();
                break;

            case "Personas":
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
        System.out.println("Ha salido del programa.");
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
