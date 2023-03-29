package Controler.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;
import view.com.company.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ControllerAsignaturas implements ActionListener, WindowListener, MouseListener {
    private ViewAsignaturas frAsignaturas;
    private  ModelAsignaturas modelAsig;
    private ModelPersonas modelPersonas;
    private ViewPersonas frPersonas;
    private dialogAsignaturas dialogo;
    private DefaultTableModel m = null;
    private boolean isDelete;

    public ControllerAsignaturas(ModelAsignaturas modelAsig, ViewAsignaturas frAsignaturas){
        this.modelAsig=modelAsig;
        this.frAsignaturas=frAsignaturas;
        try{
            iniciarVentanaAsignaturas();
            prepararBaseDatosAsignaturas();
            iniciarEventosAsignaturas();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    public void iniciarVentanaAsignaturas() {
        frAsignaturas=new ViewAsignaturas();
        frAsignaturas.setVisible(true);

    }
    public void iniciarEventosAsignaturas() {
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
        m=new DefaultTableModel();
        modelAsig=new ModelAsignaturas();
        frAsignaturas.getTable1().setModel(modelAsig.CargaDatos(m));
    }

    public void mostrarDatosDialogo(boolean isDelete) {
        this.isDelete=isDelete;
        int filaSeleccionada = frAsignaturas.getTable1().getSelectedRow();
        String nombre = null;
        String creditos = null;
        int id =-1;
        String tipo = null;
        String curso = null;
        String cuatrimestre = null;
        String id_profesor = null;
        String id_grado = null;
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila antes.");
            return;
        } else {
            id = Integer.parseInt((String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 0));
            dialogo=new dialogAsignaturas(false,isDelete,id);
            int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
            dialogo.setSize(ancho/2, alto/2);
            dialogo.setLocation(ancho/4, alto/4);
            dialogo.setTitle("Registro.");
            nombre = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 1);
            creditos = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 2);
            tipo = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 3);
            curso = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 4);
            cuatrimestre = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 5);
            id_profesor = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 6);
            id_grado = (String) frAsignaturas.getTable1().getValueAt(filaSeleccionada, 7);
            dialogo.getTxtNombre().setText(nombre);
            dialogo.getTxtCreditos().setText(creditos);
            dialogo.getComboBox1().setSelectedItem(tipo);
            dialogo.getTxtCurso().setText(curso);
            dialogo.getTxtCuatrimestre().setText(cuatrimestre);
            dialogo.getTxtIdProfesor().setText(id_profesor);
            dialogo.getTxtIdGrado().setText(id_grado);
            dialogo.setVisible(true);

        }
    }

    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == frAsignaturas.getBtnAdd()) {
                //Al pulsar Añadir  abrimos el dialogo, cuando se cierra el mismo,
                //se actualizan los datos de la tabla.
                dialogo=new dialogAsignaturas(true,false,-1);
                int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
                int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
                dialogo.setSize(ancho/2, alto/2);
                dialogo.setLocation(ancho/4, alto/4);
                dialogo.setTitle("Añadir nuevo registro.");
                dialogo.setVisible(true);
                prepararBaseDatosAsignaturas();
            } else if (e.getSource() == frAsignaturas.getBtnModify()) {
                mostrarDatosDialogo(false);
                prepararBaseDatosAsignaturas();

            } else if (e.getSource() == frAsignaturas.getBtnEliminar()) {
                // código para el botón Eliminar
                mostrarDatosDialogo(true);
                prepararBaseDatosAsignaturas();
            } else if (e.getSource() == frAsignaturas.getBtnPersonas()) {
                // código para el botón Personas
                ControllerPersonas controllerPersonas=new ControllerPersonas(modelPersonas, frPersonas);
                frAsignaturas.dispose();
            } else if (e.getSource() == frAsignaturas.getBtnVolver()) {
                // código para el botón Volver, retorna a la vista de entrada.
               ControllerEntrada controlador=new ControllerEntrada(modelAsig,frAsignaturas, modelPersonas, frPersonas);
                frAsignaturas.dispose();
            }
        }
        @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ha salido del programa.");
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
