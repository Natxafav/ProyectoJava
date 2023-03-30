package view.com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

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
       table1.revalidate();
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

      public JButton getBtnVolver() {
       return btnVolver;
    }

      public JButton getBtnModify() {
       return btnModify;
    }

    public JButton getBtnEliminar() {

        return btnEliminar;
    }

    public JButton getBtnPersonas() {
     return btnPersonas;
    }


}
