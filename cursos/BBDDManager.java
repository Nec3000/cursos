package Prac2BD.cursos;

import java.sql.*;

public class BBDDManager {
    private Connection conn;
    private String user;
    private String password;
    private String host;
    String db = "cursos_db";

    public BBDDManager(String user, String password) {
        this.user = user;
        this.password = password;
        host = "localhost:3306";
    }

    public String url() {
        return "jdbc:mysql://" + host + "/" + db;
    }

    public StringWriter run(DataBaseTask[] tasks, String[] dataArray, boolean autoCommit) throws SQLException,BBDDException {
        StringWriter result = new StringWriter();
        conn = DriverManager.getConnection(url(),user,password);
        conn.setAutoCommit(autoCommit);
        tasks[0].run(conn,"");

        result.add("fin");
        return result;
    }
}
