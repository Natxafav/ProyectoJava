package view.com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAsignaturas extends JFrame{
    private JPanel jPanelAsignaturas;
    private JTable table1;
    private JButton btnAdd;
    private JButton btnModify;
    private JButton btnEliminar;
    private JButton btnPersonas;
    private JButton btnVolver;

    public ViewAsignaturas() {
        super("ASIGNATURAS");
        setContentPane(jPanelAsignaturas);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);


    }

    public void setTableModel(DefaultTableModel model) {
        table1.setModel(model);
    }
    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JPanel getjPanelAsignaturas() {
        return jPanelAsignaturas;
    }

    public void setjPanelAsignaturas(JPanel jPanelAsignaturas) {   this.jPanelAsignaturas = jPanelAsignaturas;   }

    public JButton getBtnAdd() {
       return btnAdd;
    }

   // public void setBtnAdd(JButton btnAdd) {        this.btnAdd = btnAdd;    }
    public JButton getBtnVolver() {
       return btnVolver;
    }

   // public void setBtnVolver(JButton btnVolver) {      this.btnVolver = btnVolver;    }
    public JButton getBtnModify() {
       return btnModify;
    }

   // public void setBtnModify(JButton btnModify) {   this.btnModify = btnModify; }

    public JButton getBtnEliminar() {

        return btnEliminar;
    }

   // public void setBtnEliminar(JButton btnEliminar) {    this.btnEliminar = btnEliminar; }

    public JButton getBtnPersonas() {
     return btnPersonas;
    }

   // public void setBtnPersonas(JButton btnPersonas) {     this.btnPersonas = btnPersonas;    }

}
