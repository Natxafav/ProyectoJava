package model.com.company;

import Connecion.ConectionBD;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ModelPersonas {
    private Statement stmt;

    public DefaultTableModel CargaDatos(boolean isBuscar,DefaultTableModel m,String nombreColumna, String datoBuscar) {
        //Eliminamos los datos de la tabla antes de cargarlos.
        String query = null;
        m.setRowCount(0);
        //Cargamos los datos en la tabla
        String[] titulos = {"Id","NIF", "Nombre", "Apellido1", "Apellido2", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo"};
        m = new DefaultTableModel(null, titulos);

        try {
            ConectionBD.openConn();
            stmt = ConectionBD.getStmt();
            if(isBuscar){
                query = "SELECT * FROM persona WHERE `" + nombreColumna + "` LIKE '%" + datoBuscar + "%'";
            }else if (!isBuscar){
                query ="select * from persona";
            }
            if(stmt !=null) {
                ResultSet rs = stmt.executeQuery(query);
                String[] fila = new String[11];
                while (rs.next()) {
                    fila[0] = rs.getString("id");
                    fila[1] = rs.getString("nif");
                    fila[2] = rs.getString("nombre");
                    fila[3] = rs.getString("apellido1");
                    fila[4] = rs.getString("apellido2");
                    fila[5] = rs.getString("ciudad");
                    fila[6] = rs.getString("direccion");
                    fila[7] = rs.getString("telefono");
                    fila[8] = rs.getString("fecha_nacimiento");
                    fila[9] = rs.getString("sexo");
                    fila[10] = rs.getString("tipo");
                    m.addRow(fila);
                }
            }

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e +"Cargar datos modelPersonas");
        }
        return m;
    }

    public void agregarPersona(String nif,String nombre, String apellido1, String apellido2, String ciudad, String direccion,String telefono,String fechaNac,String sexo, String tipo) {
        //Añadimos un nuevo registro a la base de datos
        try {
            ConectionBD.openConn();
            stmt = ConectionBD.getStmt();
            String query = "INSERT INTO `persona`( `nif`, `nombre`, `apellido1`, `apellido2`, `ciudad`, `direccion`, `telefono`, `fecha_nacimiento`, `sexo`, `tipo`) VALUES ('"
                    + nif + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + ciudad + "', '"
                    + direccion + "', '" + telefono +"', '" + fechaNac+"', '" + sexo+"', '" + tipo+ "')";
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Añadir persona "+ e);
            e.printStackTrace();

        }
    }
    public void modificarPersona(int id, String nif,String nombre, String apellido1, String apellido2, String ciudad, String direccion,String telefono,String fechaNac,String sexo, String tipo) {
        //Modificamos registros de la base de datos
        try {
            DefaultTableModel m=new DefaultTableModel();
            stmt = ConectionBD.getStmt();

            String query = "UPDATE `persona` SET nif='" + nif + "', nombre='" + nombre + "', apellido1='" +
                    apellido1 + "', apellido2='" + apellido2 + "', ciudad='" + ciudad +
                    "', direccion='" + direccion + "', telefono='" + telefono +"', fecha_nacimiento='" +
                    fechaNac +"', sexo='" + sexo +"', tipo='" + tipo + "' WHERE id=" + id;
            stmt.executeUpdate(query);
            //  CargaDatos(m);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e+" modificarPersona");
            e.printStackTrace();
        }
    }

    public void eliminarPersona(int id) {
        try {

            DefaultTableModel m = new DefaultTableModel();
            stmt = ConectionBD.getStmt();
            String query = "DELETE FROM persona WHERE id=" + id;
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Eliminar persona " +e);
            throw new RuntimeException(e);
        }

    }

}
