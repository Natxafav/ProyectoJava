package view.com.company;

import Connecion.ConectionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewPanelEntrada extends JFrame {
    private JPanel panelEntrada;
    private JButton asignaturasButton;
    private JButton personasButton;
    private JLabel labelTitulo;
     private JButton btnSalir;
    private JComboBox comboDataBase;
    private JComboBox comboFiltrar;
    private JTextField txtBusqueda;
    private JButton btnBuscar;
    private Statement stmt;
    public ViewPanelEntrada() {

        super("Gestión de datos.");
        setContentPane(panelEntrada);
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);
        String[] opciones={"","Asignaturas", "Personas"};
        for(String opcion : opciones) {
            comboDataBase.addItem(opcion);
        }
        comboDataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboFiltrar.removeAllItems();
                ArrayList<String> filtroBusqueda = new ArrayList<>();
                if(comboDataBase.getSelectedItem().toString().equals("Asignaturas")){

                    String[] titulos = {"id", "nombre", "creditos", "tipo", "curso", "cuatrimestre", "id_profesor", "id_grado"};

                    for (String titulo : titulos) {
                        comboFiltrar.addItem(titulo);
                    }
                }else if(comboDataBase.getSelectedItem().toString().equals("Personas")){
                    String[] titulos1 = {"id","nif", "nombre", "apellido1", "apellido2", "ciudad", "direccion", "telefono", "fecha_nacimiento", "sexo", "tipo"};
                    for (String titulo1 : titulos1) {
                        comboFiltrar.addItem(titulo1);
                    }
                }
            }
        });

    }



    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    public JComboBox getComboDataBase() {
        return comboDataBase;
    }

    public void setComboDataBase(JComboBox comboDataBase) {
        this.comboDataBase = comboDataBase;
    }

    public JComboBox getComboFiltrar() {
        return comboFiltrar;
    }

    public void setComboFiltrar(JComboBox comboFiltrar) {
        this.comboFiltrar = comboFiltrar;
    }

    public JTextField getTxtBusqueda() {
        return txtBusqueda;
    }

    public void setTxtBusqueda(JTextField txtBusqueda) {
        this.txtBusqueda = txtBusqueda;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }


    public JPanel getPanelEntrada() {
        return panelEntrada;
    }

    public void setPanelEntrada(JPanel panelEntrada) {
        this.panelEntrada = panelEntrada;
    }

    public JButton getAsignaturasButton() {
        return asignaturasButton;
    }

    public void setAsignaturasButton(JButton asignaturasButton) {
        this.asignaturasButton = asignaturasButton;
    }

    public JButton getPersonasButton() {
        return personasButton;
    }

    public void setPersonasButton(JButton personasButton) {
        this.personasButton = personasButton;
    }

}