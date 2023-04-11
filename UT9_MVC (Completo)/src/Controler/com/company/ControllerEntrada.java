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
    private  ViewPersonas frPersonas=new ViewPersonas();
    private DefaultTableModel m = null;
    private ModelAsignaturas modelAsignaturas=new ModelAsignaturas();
    private ModelPersonas modelPersonas=new ModelPersonas();
    private ViewAsignaturas frAsignaturas=new ViewAsignaturas();
    private ControllerAsignaturas controllerAsignaturas;
    private ControllerPersonas controllerPersonas;


    // Constructor lanza cada uno de los procedimientos de la aplicación.
    public ControllerEntrada(ModelAsignaturas modelAsignaturas, ViewAsignaturas frAsignaturas, ModelPersonas modelPersonas, ViewPersonas frPersonas) {
        this.modelAsignaturas=modelAsignaturas;
        this.modelPersonas=modelPersonas;
        this.frAsignaturas=frAsignaturas;
        this.frPersonas=frPersonas;

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
        frEntrada.getBtnBuscar().addActionListener(this::actionPerformed);
        frEntrada.getComboFiltrar().addActionListener(this::actionPerformed);
        frEntrada.getComboDataBase().addActionListener(this::actionPerformed);
        frEntrada.getTxtBusqueda().addActionListener(this::actionPerformed);
        frEntrada.addWindowListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Según el botón pulsado, realiza una acción.
        try {
        if (e.getSource() == frEntrada.getBtnBuscar()) {
            String nombreDataBase=(String) frEntrada.getComboDataBase().getSelectedItem();
            String columnaFiltrar=(String) frEntrada.getComboFiltrar().getSelectedItem();
            String datosBuscar= frEntrada.getTxtBusqueda().getText();
            m=new DefaultTableModel();
            assert nombreDataBase != null;
            if (nombreDataBase.equals("Asignaturas")){
                controllerAsignaturas=new ControllerAsignaturas(true,modelAsignaturas,frAsignaturas,columnaFiltrar, datosBuscar);
                frEntrada.dispose();
                frAsignaturas.getTable1().setModel(modelAsignaturas.CargaDatos(true,m,columnaFiltrar,datosBuscar));

            }else if (nombreDataBase.equals("Personas")){
                controllerPersonas=new ControllerPersonas(true,modelPersonas,frPersonas,columnaFiltrar, datosBuscar);
                frEntrada.dispose();
                frPersonas.getTable1().setModel(modelPersonas.CargaDatos(true,m,columnaFiltrar,datosBuscar));
            }
        }
        String entrada = e.getActionCommand();
        switch (entrada) {
            case "Salir":
                System.out.println("Ha salido del programa.");
                System.exit(0);
                break;

            case "Asignaturas":
                controllerAsignaturas= new ControllerAsignaturas(false,modelAsignaturas, frAsignaturas,"","");
                frEntrada.dispose();
                break;

            case "Personas":
                ControllerPersonas controllerPersonas=new ControllerPersonas(false,modelPersonas,frPersonas,"","");
                frEntrada.dispose();
                break;

        }
    } catch (Exception ex) {
            throw new RuntimeException(ex);
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
