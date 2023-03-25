package Controler.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelAsignaturas;
import view.com.company.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ControllerAsignaturas implements ActionListener, WindowListener, MouseListener {
    private final ViewAsignaturas frAsignaturas=new ViewAsignaturas();
    private final ViewPersonas frPersonas=new ViewPersonas();
    private  ModelAsignaturas modeloAsig;
    private dialogAdd dialogo;
    private DefaultTableModel m = null;

    public ControllerAsignaturas(){
        System.out.println("Controlador Asignaturas en el inicio controlador de asignaturas");
        try{
            System.out.println("Controlador Asignaturas en el inicio controlador de asignaturas dentro del try");
            iniciarVentanaAsignaturas();
            prepararBaseDatosAsignaturas();
            System.out.println("despues de prepBaseDatos en el controllerAsig");
            iniciarEventosAsignaturas();
            System.out.println("despues de inicEvenAs en el controllerAsig");


        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    public void iniciarVentanaAsignaturas() {
        System.out.println("Dentro del programa iniciarVentanaAsignaturas");
        frAsignaturas.setVisible(true);

    }
    public void iniciarEventosAsignaturas() {
        System.out.println("Dentro del metodo iniciarEventos");
        frAsignaturas.getBtnAdd().setActionCommand("AddAccion");
        frAsignaturas.getBtnAdd().addActionListener(this::actionPerformed);
        frAsignaturas.getBtnModify().addActionListener(this::actionPerformed);
        frAsignaturas.getBtnEliminar().addActionListener(this::actionPerformed);
        frAsignaturas.getBtnPersonas().addActionListener(this::actionPerformed);
        frAsignaturas.getBtnVolver().addActionListener(this::actionPerformed);
        frAsignaturas.getjPanelAsignaturas().addMouseListener(this);
        frAsignaturas.getTable1().addMouseListener(this);
        frAsignaturas.addWindowListener(this);


    }
    public void prepararBaseDatosAsignaturas() {
        System.out.println("dentro del método preparar base de datos");
        m=new DefaultTableModel();
        modeloAsig=new ModelAsignaturas();
        frAsignaturas.getTable1().setModel(modeloAsig.CargaDatos(m));
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("actPErf del controllerAsignat 1º linea");
            if (e.getSource() == frAsignaturas.getBtnAdd()) {
                dialogo=new dialogAdd();
                int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
                int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
                dialogo.setSize(ancho, alto);
                dialogo.setLocation(5, 5);
                dialogo.setTitle("Añadir nuevo registro.");
                dialogo.setVisible(true);
                prepararBaseDatosAsignaturas();
            } else if (e.getSource() == frAsignaturas.getBtnModify()) {
                System.out.println("Es el boton modificar");

            } else if (e.getSource() == frAsignaturas.getBtnEliminar()) {
                // código para el botón Eliminar
                System.out.println("Este es el mboton eliminar");
            } else if (e.getSource() == frAsignaturas.getBtnPersonas()) {
                // código para el botón Personas
                System.out.println("este es el boton personas");
            } else if (e.getSource() == frAsignaturas.getBtnVolver()) {
                // código para el botón Volver
                frAsignaturas.dispose();
                ControllerEntrada controlador=new ControllerEntrada();
            }
        }

public void refrescarDatos(){
        m=new DefaultTableModel();
    System.out.println("Entrando en refrescar datos");
    frAsignaturas.setTableModel(m);
    modeloAsig.CargaDatos(m);
}


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ha salido del programa exit wlistener controllerAsignaturas");
        frAsignaturas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
