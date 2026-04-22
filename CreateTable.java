package cursos;

import java.sql.*;

public class CreateTable implements DataBaseTask {
	public CreateTable() {}
    @Override
    public void run(Connection conn, String data) throws SQLException,BBDDException {
    	String sql = "CREATE TABLE imparte("+
    				 "Fecha DATE, "+
    				 "n_modulo INT NOT NULL,"+
                     "curso_id INT NOT NULL,"+
    				 "aula_id INT,"+
    				 "profesor_id INT," +
    				 "PRIMARY KEY(curso_id,n_modulo,aula_id,profesor_id),"+
    				 "FOREIGN KEY(curso_id, n_modulo) REFERENCES modulo(curso_id, n_modulo) ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(aula_id) REFERENCES aula(id) ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(profesor_id) REFERENCES profesor(id) ON DELETE CASCADE ON  UPDATE CASCADE)";

            Statement st = conn.createStatement();
            int rows = st.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rows);
            st.close();
    }
}
