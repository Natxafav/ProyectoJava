package model.com.company;

import Connecion.ConectionBD;
import Controler.com.company.ControllerAsignaturas;
import view.com.company.ViewAsignaturas;
import view.com.company.dialogAdd;

import javax.swing.table.DefaultTableModel;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelAsignaturas {
 private Statement stmt;

    public DefaultTableModel CargaDatos(DefaultTableModel m) {
        m.setRowCount(0);
        String[] titulos = {"ID", "Nombre", "Créditos", "Tipo", "Curso", "Cuatrimestre", "Id Profesor", "Id Grado"};
        m = new DefaultTableModel(null,titulos);
        try {
            ConectionBD.openConn();
            stmt = ConectionBD.getStmt();
            ResultSet rs = stmt.executeQuery("select * from asignatura");
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("creditos");
                fila[3] = rs.getString("tipo");
                fila[4] = rs.getString("curso");
                fila[5] = rs.getString("cuatrimestre");
                fila[6] = rs.getString("id_profesor");
                fila[7] = rs.getString("id_grado");
                m.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return m;
    }
     public void agregarAsignatura(String nombre, int creditos, String tipo, int curso, int cuatrimestre, int id_profesor, int id_grado) {
        try {
            stmt = ConectionBD.getStmt();
            String query = "INSERT INTO asignatura (nombre, creditos, tipo, curso, cuatrimestre, id_profesor, id_grado) VALUES ('" + nombre + "', " + creditos + ", '" + tipo + "', " + curso + ", " + cuatrimestre + ", " + id_profesor + ", " + id_grado + ")";
            stmt.executeUpdate(query);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

/*
    public void modificarAsignatura(int id, String nombre, int creditos, String tipo, int curso, int cuatrimestre, int id_profesor, int id_grado) {
        try {
            ModelAsignaturas modelAsignaturas = new ModelAsignaturas();
            ViewAsignaturas vistaAsignaturas = new ViewAsignaturas();
            DefaultTableModel m=new DefaultTableModel();
            stmt = ConectionBD.getStmt();
            String query = "UPDATE asignatura SET nombre='" + nombre + "', creditos=" + creditos + ", tipo='" + tipo + "', curso=" + curso + ", cuatrimestre=" + cuatrimestre + ", id_profesor=" + id_profesor + ", id_grado=" + id_grado + " WHERE id=" + id;
            stmt.executeUpdate(query);
            CargaDatos(m);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAsignatura(int id) {
        try {
            ModelAsignaturas modelAsignaturas = new ModelAsignaturas();
            ViewAsignaturas vistaAsignaturas = new ViewAsignaturas();
            DefaultTableModel m=new DefaultTableModel();
            stmt = ConectionBD.getStmt();
            String query = "DELETE FROM asignatura WHERE id=" + id;
            stmt.executeUpdate(query);
            CargaDatos(m);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
