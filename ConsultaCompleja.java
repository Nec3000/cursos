package cursos;

import java.sql.*;
import java.util.ArrayList;

public class ConsultaCompleja extends ConsultaConResultado<Properties> {
    /**
     * Realiza una consulta
     *
     * @param conn La conexion ya abierta
     * @param data un entero que indica un porcentaje
     *
     * @throws BBDDException, cuando `data` no se pueda convertir
     *         en un entero
     * @throws SQLException, cuando se produzca la misma al ejecutar
     *         los comandos sql.
     */
    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
    }
}