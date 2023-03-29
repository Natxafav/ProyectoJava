package view.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelAsignaturas;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dialogAsignaturas extends JDialog {
    private Statement stmt;
    private JPanel contentPane, jPanelTexto, jPanel;
    private JButton buttonOK, buttonCancel;
    private JTextField txtNombre, txtCreditos, txtCurso,txtCuatrimestre,txtIdProfesor,txtIdGrado;
    private JLabel lblAsignaturas,lblID_Grado,lblId_Profesor, lblCuatrimestre,lblCurso, lblTipo, lblCreditos, lblNombre;
    private JComboBox comboBox1;
    private String nombre, creditosSt, tipo, cursoSt, cuatrimestreSt, id_profesorSt, id_gradoSt;
    private int cuatrimestre,creditos,curso,id_profesor,id_grado;
    private boolean isAdd=true, isDelete=false;
    private int id=-1;
    public dialogAsignaturas(boolean isAdd, boolean isDelete, int id) {
        this.id=id;
        this.isAdd=isAdd;
        this.isDelete=isDelete;
        ArrayList<String> tiposAsignaturas = new ArrayList<>();
        try {
            ConectionBD.openConn();
            stmt = ConectionBD.getStmt();
            String query = "SELECT DISTINCT tipo FROM asignatura";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                tiposAsignaturas.add(tipo);
            }
            for (String tipo : tiposAsignaturas) {
                comboBox1.addItem(tipo);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los tipos de asignaturas: " + e.getMessage());
        }

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
        ModelAsignaturas modelo=new ModelAsignaturas();
        nombre=txtNombre.getText();
        creditosSt=txtCreditos.getText();
        tipo= (String) comboBox1.getSelectedItem();
        cursoSt=txtCurso.getText();
        cuatrimestreSt=txtCuatrimestre.getText();
        id_profesorSt=txtIdProfesor.getText();
        id_gradoSt=txtIdGrado.getText();
        creditos= Integer.parseInt(creditosSt);
        curso=Integer.parseInt(cursoSt);
        cuatrimestre= Integer.parseInt(cuatrimestreSt);
        id_profesor= Integer.parseInt(id_profesorSt);
        id_grado= Integer.parseInt(id_gradoSt);
        if(isAdd==true){
            modelo.agregarAsignatura(nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado);

        } else if (isAdd==false&&isDelete==false) {

            setTitle("Modificar Registro");
            modelo.modificarAsignatura(id,nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado);

        }else if(isAdd==false && isDelete==true){
            System.out.println(id+" Esta es la id");
            setTitle("Eliminar registro.");
            modelo.eliminarAsignatura(id);
        }
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
    public JComboBox getComboBox1() {
        return comboBox1;
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

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtCreditos() {
        return txtCreditos;
    }

    public void setTxtCreditos(JTextField txtCreditos) {
        this.txtCreditos = txtCreditos;
    }

    public JTextField getTxtCurso() {
        return txtCurso;
    }

    public void setTxtCurso(JTextField txtCurso) {
        this.txtCurso = txtCurso;
    }

    public JTextField getTxtCuatrimestre() {
        return txtCuatrimestre;
    }

    public void setTxtCuatrimestre(JTextField txtCuatrimestre) {
        this.txtCuatrimestre = txtCuatrimestre;
    }

    public JTextField getTxtIdProfesor() {
        return txtIdProfesor;
    }

    public void setTxtIdProfesor(JTextField txtIdProfesor) {
        this.txtIdProfesor = txtIdProfesor;
    }

    public JTextField getTxtIdGrado() {
        return txtIdGrado;
    }

    public void setTxtIdGrado(JTextField txtIdGrado) {
        this.txtIdGrado = txtIdGrado;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }
    public JPanel getjPanelTexto() {
        return jPanelTexto;
    }

    public void setjPanelTexto(JPanel jPanelTexto) {
        this.jPanelTexto = jPanelTexto;
    }
    public static void main(String[] args) {
        dialogAsignaturas dialogo = new dialogAsignaturas(true,false,-1);
        dialogo.pack();
        dialogo.setVisible(true);
        System.exit(0);
    }

}
