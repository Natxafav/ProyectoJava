package view.com.company;

import Connecion.ConectionBD;
import model.com.company.ModelPersonas;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dialogPersonas extends JDialog {
    private Statement stmt;
    private JPanel contentPane,jPanelTexto,jPanel;
    private JTextField txtNif,txtNombre,txtApellido1,txtApellido2,txtCiudad,txtDireccion,txtTelefono,txtFecha_Nacimiento;
    private JComboBox comboSexo,comboTipo;
    private JButton buttonOK,buttonCancel;
    private JLabel lblNif, lblNombre, lblApellido1, lblApellido2,lblCiudad, lblDireccion,lblTelefono,lblFecha_Nacimiento,lblSexo,lblTipo;
    private String nif, nombre, apellido1, apellido2, ciudad,direccion, telefono, fecha_nacimiento, sexo, tipo;
    private boolean isAdd=true, isDelete=false;
    private int id=-1;

    public dialogPersonas(boolean isAdd, boolean isDelete, int id) {
        this.id=id;
        this.isAdd=isAdd;
        this.isDelete=isDelete;
        ArrayList<String> tiposPersonas = new ArrayList<>();
        ArrayList<String> sexoPersonas = new ArrayList<>();
        try {
           ConectionBD.openConn();
            stmt = ConectionBD.getStmt();
            String query_tipo = "SELECT DISTINCT tipo FROM persona";
            ResultSet rs_tipo = stmt.executeQuery(query_tipo);
            while (rs_tipo.next()) {
                String tipo = rs_tipo.getString("tipo");
                tiposPersonas.add(tipo);
            }
            for (String tipo : tiposPersonas) {
                comboTipo.addItem(tipo);
            }


        } catch (SQLException e) {
            System.err.println("Error al obtener los tipos : " + e.getMessage());
        }
         try{
             String query_sexo="SELECT DISTINCT sexo FROM persona";
             ResultSet rs_sexo = stmt.executeQuery(query_sexo);
             while (rs_sexo.next()) {
                 String sexo = rs_sexo.getString("sexo");
                 sexoPersonas.add(sexo);

             }
             for (String sexo : sexoPersonas) {
                 comboSexo.addItem(sexo);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
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
        ModelPersonas modelo=new ModelPersonas();
        nif= txtNif.getText();
        System.out.println("Este es el nif"+nif);
        nombre= txtNombre.getText();
        apellido1= txtApellido1.getText();
        apellido2= txtApellido2.getText();
        ciudad= txtCiudad.getText();
        direccion= txtDireccion.getText();
        telefono= txtTelefono.getText();
        fecha_nacimiento= txtFecha_Nacimiento.getText();
        sexo= (String) comboSexo.getSelectedItem();
        tipo= (String) comboTipo.getSelectedItem();
        if(isAdd==true){
            modelo.agregarPersona(nif,nombre,apellido1,apellido2,ciudad,direccion,telefono,fecha_nacimiento,sexo,tipo);

        } else if (isAdd==false&&isDelete==false) {
            setTitle("Modificar Registro");
            modelo.modificarPersona(id,nif,nombre,apellido1,apellido2,ciudad,direccion,telefono,fecha_nacimiento,sexo,tipo);

        }else if(isAdd==false && isDelete==true){
            System.out.println(id+" Esta es la id");
            setTitle("Eliminar registro.");
            modelo.eliminarPersona(id);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JComboBox getComboSexo() {
        return comboSexo;
    }

    public JComboBox getComboTipo() {
        return comboTipo;
    }

    public Statement getStmt() {
        return stmt;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId() {
        return id;
    }

    public JTextField getTxtNif() {
        return txtNif;
    }

    public void setTxtNif(JTextField txtNif) {
        this.txtNif = txtNif;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    public void setTxtApellido1(JTextField txtApellido1) {
        this.txtApellido1 = txtApellido1;
    }

    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    public void setTxtApellido2(JTextField txtApellido2) {
        this.txtApellido2 = txtApellido2;
    }

    public JTextField getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(JTextField txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtFecha_Nacimiento() {
        return txtFecha_Nacimiento;
    }

    public void setTxtFecha_Nacimiento(JTextField txtFecha_Nacimiento) {
        this.txtFecha_Nacimiento = txtFecha_Nacimiento;
    }

    public void setComboSexo(JComboBox comboSexo) {
        this.comboSexo = comboSexo;
    }

    public void setComboTipo(JComboBox comboTipo) {
        this.comboTipo = comboTipo;
    }

    public JLabel getLblNif() {
        return lblNif;
    }

    public void setLblNif(JLabel lblNif) {
        this.lblNif = lblNif;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblApellido1() {
        return lblApellido1;
    }

    public void setLblApellido1(JLabel lblApellido1) {
        this.lblApellido1 = lblApellido1;
    }

    public JLabel getLblApellido2() {
        return lblApellido2;
    }

    public void setLblApellido2(JLabel lblApellido2) {
        this.lblApellido2 = lblApellido2;
    }

    public JLabel getLblCiudad() {
        return lblCiudad;
    }

    public void setLblCiudad(JLabel lblCiudad) {
        this.lblCiudad = lblCiudad;
    }

    public JLabel getLblDireccion() {
        return lblDireccion;
    }

    public void setLblDireccion(JLabel lblDireccion) {
        this.lblDireccion = lblDireccion;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }

    public JLabel getLblFecha_Nacimiento() {
        return lblFecha_Nacimiento;
    }

    public void setLblFecha_Nacimiento(JLabel lblFecha_Nacimiento) {
        this.lblFecha_Nacimiento = lblFecha_Nacimiento;
    }

    public JLabel getLblSexo() {
        return lblSexo;
    }

    public void setLblSexo(JLabel lblSexo) {
        this.lblSexo = lblSexo;
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
        dialogPersonas dialog = new dialogPersonas(true, false, -1);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
