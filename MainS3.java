package cursos;

public class MainS3 {

    // Comprobar
    public static void test() {
        // Crea el gestor de conexiones
        BBDDManager cm = new BBDDManager("alumno","bbdd-upm");

        // Crear las tareas
        DataBaseTask[] tasks = {
        	new AddColumn(),
            new ConsultaSimple()
        };
        String[] data = {
        	"",
            "ASC"
        };

        // Llamar a run:
        StringWriter result = cm.run(tasks, data, true);
        System.out.println(result);
        
    }

    public static void main(String[] args) {
        test();
    }
}


