package view.com.company;

import javax.swing.*;

public class ViewPersonas extends JFrame {
    private JPanel jPanePersonas;
    private JButton btnAdd;
    private JButton btnAsignaturas;
    private JButton btnModify;
    private JButton btnEliminar;
    private JTable table1;
    public ViewPersonas() {
        super("PERSONAS");
        setContentPane(jPanePersonas);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);
    }

    public JPanel getjPanePersonas() {
        return jPanePersonas;
    }

    public void setjPanePersonas(JPanel jPanePersonas) {
        this.jPanePersonas = jPanePersonas;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnAsignaturas() {
        return btnAsignaturas;
    }

    public void setBtnAsignaturas(JButton btnAsignaturas) {
        this.btnAsignaturas = btnAsignaturas;
    }

    public JButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(JButton btnModify) {
        this.btnModify = btnModify;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }
}
