package view.com.company;

import model.com.company.ModelAsignaturas;

import javax.swing.*;
import java.awt.event.*;

public class dialogAdd extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jPanelTexto;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JTextField txtCreditos;
    private JTextField txtTipo;
    private JTextField txtCurso;
    private JTextField txtCuatrimestre;
    private JTextField txtIdProfesor;
    private JTextField txtIdGrado;
    private JLabel lblCreditos;
    private JLabel lblTipo;
    private JLabel lblCurso;
    private JLabel lblCuatrimestre;
    private JLabel lblId_Profesor;
    private JLabel lblID_Grado;
    private JLabel lblAsignaturas;
    private String nombre, creditosSt, tipo, cursoSt, cuatrimestreSt, id_profesorSt, id_gradoSt;
    private int creditos;
    private int curso;
    private int cuatrimestre;
    private int id_profesor;
    private int id_grado;
    public dialogAdd() {
        System.out.println("Se genera el dialogo");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        nombre=txtNombre.getText();
        creditosSt=txtCreditos.getText();
        tipo=txtTipo.getText();
        cursoSt=txtCurso.getText();
        cuatrimestreSt=txtCuatrimestre.getText();
        id_profesorSt=txtIdProfesor.getText();
        id_gradoSt=txtIdGrado.getText();
        creditos= Integer.parseInt(creditosSt);
        curso=Integer.parseInt(cursoSt);
        cuatrimestre= Integer.parseInt(cuatrimestreSt);
        id_profesor= Integer.parseInt(id_profesorSt);
        id_grado= Integer.parseInt(id_gradoSt);
        ModelAsignaturas modelo=new ModelAsignaturas();
        modelo.agregarAsignatura(nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
       nombre="";
       creditosSt="";
       tipo="";
       cursoSt="";
       cuatrimestreSt="";
       id_profesorSt="";
       id_gradoSt="";
       dispose();
    }



    public String getNombre() {
        return nombre;
    }

    public String getCreditosSt() {
        return creditosSt;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCursoSt() {
        return cursoSt;
    }

    public String getCuatrimestreSt() {
        return cuatrimestreSt;
    }

    public String getId_profesorSt() {
        return id_profesorSt;
    }

    public String getId_gradoSt() {
        return id_gradoSt;
    }
    public int getCreditos() {
        return creditos;
    }
    public int getCurso() {
        return curso;
    }
    public int getCuatrimestre() {
        return cuatrimestre;
    }
    public int getId_profesor() {
        return id_profesor;
    }
    public int getId_grado() {
        return id_grado;
    }

    public static void main(String[] args) {
        dialogAdd dialogo = new dialogAdd();
        dialogo.pack();
        dialogo.setVisible(true);
        System.exit(0);
    }

}
