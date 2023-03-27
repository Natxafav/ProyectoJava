package view.com.company;

import javax.swing.*;

public class ViewPanelEntrada extends JFrame {
    private JPanel panelEntrada;
    private JButton asignaturasButton;
    private JButton personasButton;
    private JLabel labelTitulo;
     private JButton btnSalir;

    public ViewPanelEntrada() {

        super("Gestión de datos.");
        setContentPane(panelEntrada);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);

    }
    public JLabel getLabelTitulo() {
        return labelTitulo;
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