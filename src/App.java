public class App {
    public static void main(String[] args) {

        Universidad univ = new Universidad();

        Carrera sistemas = new Carrera("Sistemas");

        Profesor prof1 = new Profesor("Laura", "Gomez", 45, "22334455", "Programacion", 20);

        Estudiante e1 = new Estudiante("Tomas", "Cavallera", 20, "44999888", sistemas);
        Estudiante e2 = new Estudiante("Juan", "Perez", 21, "40987654", sistemas);
        Estudiante e3 = new Estudiante("Ana", "Lopez", 22, "44111222", sistemas);

        Materia m1 = new Materia("POO", 9, prof1);
        Materia m2 = new Materia("Algoritmos", 8, prof1);

        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        sistemas.agregarEstudiante(e1);
        sistemas.agregarEstudiante(e2);
        sistemas.agregarEstudiante(e3);

        univ.agregarMiembro(e1);
        univ.agregarMiembro(e2);
        univ.agregarMiembro(e3);
        univ.agregarMiembro(prof1);

        System.out.println("\n---- LISTA DE MIEMBROS (POLIMORFISMO) ----");
        univ.listarMiembros();

        // ------- PROBANDO RECURSIVIDAD --------
        Estudiante[] arr = {e1, e2, e3};

        System.out.println("\nEstudiantes en Sistemas (recursivo): " +
                Universidad.contarEstudiantesRecursivo(arr, "Sistemas", 0));

        System.out.println("Estudiantes en Sistemas (iterativo): " +
                Universidad.contarEstudiantesIterativo(arr, "Sistemas"));

        // ------- ORDENAMIENTO Y BÚSQUEDA BINARIA --------
        System.out.println("\nBuscando 'Lopez' por búsqueda binaria...");
        int pos = Universidad.busquedaBinariaEstudiantes(arr, "Lopez");
        System.out.println("Indice encontrado = " + pos);
    }
}
