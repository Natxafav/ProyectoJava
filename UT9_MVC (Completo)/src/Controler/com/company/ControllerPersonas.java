package Controler.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;
import view.com.company.ViewAsignaturas;
import view.com.company.ViewPersonas;
import view.com.company.dialogPersonas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ControllerPersonas implements ActionListener, WindowListener, MouseListener {
    private ViewAsignaturas frAsignaturasP;
    private  ModelAsignaturas modelAsigP;
    private ViewPersonas frPersonasP;
    private ModelPersonas modelPersonasP;
    private dialogPersonas dialogoPersonas;
    private DefaultTableModel m = null;
    private boolean isDelete;
    private boolean buscar=false;

    public ControllerPersonas(ModelPersonas modelPersonasP, ViewPersonas frPersonasP){
        this.modelPersonasP=modelPersonasP;
        this.frPersonasP=frPersonasP;
        try{
            iniciarVentanaPersonas();
            prepararBaseDatosPersonas();
            iniciarEventosPersonas();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    public void iniciarVentanaPersonas() {
        frPersonasP=new ViewPersonas();
        frPersonasP.setVisible(true);

    }
    public void iniciarEventosPersonas() {

        frPersonasP.getBtnAdd().addActionListener(this::actionPerformed);
        frPersonasP.getBtnModify().addActionListener(this::actionPerformed);
        frPersonasP.getBtnEliminar().addActionListener(this::actionPerformed);
        frPersonasP.getBtnAsignaturas().addActionListener(this::actionPerformed);
        frPersonasP.getBtnVolver().addActionListener(this::actionPerformed);
        frPersonasP.getjPanePersonas().addMouseListener(this);
        frPersonasP.getTable1().addMouseListener(this);
        frPersonasP.addWindowListener(this);

    }
    public void prepararBaseDatosPersonas() {
        m=new DefaultTableModel();
        modelPersonasP=new ModelPersonas();
        frPersonasP.getTable1().setModel(modelPersonasP.CargaDatos(m));
    }

    public void mostrarDatosDialogoPersona(boolean isDelete) {
        this.isDelete=isDelete;
        int filaSeleccionada = frPersonasP.getTable1().getSelectedRow();
        int id =-1;
        String nif=null;
        String nombre = null;
        String apellido1 = null;
        String apellido2 = null;
        String ciudad = null;
        String direccion = null;
        String telefono = null;
        String fecha_nacimiento = null;
        String sexo = null;
        String tipo = null;
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila antes.");
            return;
        } else {
            id = Integer.parseInt((String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 0));
            System.out.println("Esta es la id de Personas "+id);
            dialogoPersonas=new dialogPersonas(false,isDelete,id);
            int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
            dialogoPersonas.setSize(ancho/2, alto/2);
            dialogoPersonas.setLocation(ancho/4, alto/4);
            dialogoPersonas.setTitle("Registro.");
            nif=(String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 1);
            nombre = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 2);
            apellido1 = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 3);
            apellido2 = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 4);
            ciudad = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 5);
            direccion = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 6);
            telefono = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 7);
            fecha_nacimiento = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 8);
            sexo = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 9);
            tipo = (String) frPersonasP.getTable1().getValueAt(filaSeleccionada, 10);
            dialogoPersonas.getTxtNif().setText(nif);
            dialogoPersonas.getTxtNombre().setText(nombre);
            dialogoPersonas.getTxtApellido1().setText(apellido1);
            dialogoPersonas.getTxtApellido2().setText(apellido2);
            dialogoPersonas.getTxtCiudad().setText(ciudad);
            dialogoPersonas.getTxtDireccion().setText(direccion);
            dialogoPersonas.getTxtTelefono().setText(telefono);
            dialogoPersonas.getTxtFecha_Nacimiento().setText(fecha_nacimiento);
            dialogoPersonas.getComboSexo().setSelectedItem(sexo);
            dialogoPersonas.getComboTipo().setSelectedItem(tipo);
            dialogoPersonas.setVisible(true);

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frPersonasP.getBtnAdd()) {
            //Al pulsar Añadir  abrimos el dialogo, cuando se cierra el mismo,
            //se actualizan los datos de la tabla.
            dialogoPersonas=new dialogPersonas(true,false,-1);
            System.out.println("Se crea el dialogo personas");
            int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
            dialogoPersonas.setSize(ancho/2, alto/2);
            dialogoPersonas.setLocation(ancho/4, alto/4);
            dialogoPersonas.setTitle("Añadir nuevo registro.");
            dialogoPersonas.setVisible(true);
            prepararBaseDatosPersonas();
        } else if (e.getSource() == frPersonasP.getBtnModify()) {
            mostrarDatosDialogoPersona(false);
            prepararBaseDatosPersonas();

        } else if (e.getSource() == frPersonasP.getBtnEliminar()) {
            // código para el botón Eliminar
            mostrarDatosDialogoPersona(true);
            prepararBaseDatosPersonas();
        } else if (e.getSource() == frPersonasP.getBtnAsignaturas()) {
            // código para el botón Personas
            ControllerAsignaturas controllerAsignaturas=new ControllerAsignaturas(false,modelAsigP,frAsignaturasP,"","");
            frPersonasP.dispose();

        } else if (e.getSource() == frPersonasP.getBtnVolver()) {
            // código para el botón Volver, retorna a la vista de entrada.
            ControllerEntrada controlador=new ControllerEntrada(modelAsigP,frAsignaturasP,modelPersonasP,frPersonasP);
            frPersonasP.dispose();
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ha salido del programa.");
        frPersonasP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
