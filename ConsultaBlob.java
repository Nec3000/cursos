package cursos;

import java.sql.*;
import java.io.*;
import java.util.*;

public class ConsultaBlob implements DataBaseTask {
    /**
     * Realiza una consulta que recupera una imagen desde una bbdd.
     *
     * @param conn La conexion ya abierta
     * @param data el nombre del edificio (exacto)
     *
     * @throws SQLException, cuando se produzca la misma al ejecutar
     *         los comandos sql.
     * @throws BBDDException, cuando se produzca una IOException,
     *         fija `when` a "error archivo"
     * @throws IllegalArgumentException, cuando el edificio no exista
     *         en la base de datos.
     */
    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
    }
}