package cursos;

import java.sql.*;
import java.util.*;

import cursos.Properties;

public class ConsultaConFiltro extends ConsultaConResultado<Properties> {
    /**
     * Obtiene los profesores que imparten un modulo cuyo titulo
     * contiene la cadena dada.
     *
     * @throws BBDDException, cuando data este vacia. Se debe fijar
     *         when a "filtro vacio"
     * @throws SQLException, cuando se produzca la misma al ejecutar
     *         modificar la tabla.
     */
    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
    	if(data.isEmpty()) {
    		throw new BBDDException(null,"filtro vacio");
    	}
        super.resultado = new ArrayList<Properties>();
        try(PreparedStatement psI= conn.prepareStatement("SELECT p.*, m.curso_id, m.titulo FROM profesor p JOIN imparte i ON p.id = i.profesor_id JOIN modulo m ON i.curso_id = m.curso_id AND i.n_modulo = m.n_modulo WHERE m.titulo LIKE ? ORDER BY p.apellido1 ASC")){
        	psI.setString(1,"%"+data+"%");
        	ResultSet rs1 = psI.executeQuery();
            while(rs1.next()) {
                String apellido1 = rs1.getString("apellido1");
                String apellido2 = rs1.getString("apellido2");
                String nombre = rs1.getString("nombre");
                String curso_id = rs1.getString("curso_id");
                String titulo = rs1.getString("titulo");
                String datos = curso_id+"-"+titulo;
                Properties fila = new Properties(nombre, apellido1, apellido2,datos);
                resultado.add(fila);
            }
        }catch(SQLException e) {
        	throw new SQLException(e);
        }
    }
}