// App.java
public class App {
    public static void main(String[] args) {
        Universidad univ = new Universidad();
        Carrera sistemas = new Carrera("Sistemas");

        Profesor prof1 = new Profesor("Laura", "Gomez", 45, "22334455", "Programacion", 20);
        Estudiante e1 = new Estudiante("Tomas", "Cavallera", 20, "44999888", sistemas);
        Estudiante e2 = new Estudiante("Juan", "Perez", 21, "40987654", sistemas);

        Materia m1 = new Materia("POO", 9, prof1);
        Materia m2 = new Materia("Algoritmos", 8, prof1);

        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        sistemas.agregarEstudiante(e1);
        sistemas.agregarEstudiante(e2);

        univ.agregarMiembro(e1);
        univ.agregarMiembro(e2);
        univ.agregarMiembro(prof1);

        System.out.println("---- LISTA DE MIEMBROS (POLIMORFISMO) ----");
        univ.listarMiembros();

        GestorInscripciones gestor = new GestorInscripciones();
        SolicitudInscripcion s1 = new SolicitudInscripcion(e1, m1);
        SolicitudInscripcion s2 = new SolicitudInscripcion(e2, m2);

        gestor.agregarSolicitud(s1);
        gestor.agregarSolicitud(s2);

        System.out.println("\nSolicitudes pendientes (top): " + gestor.verSiguienteSolicitud());
        System.out.println("Procesando una solicitud (pop - LIFO)...");
        SolicitudInscripcion procesada = gestor.procesarSiguienteSolicitud();
        System.out.println("Procesada: " + procesada);

        System.out.println("\nSolicitudes pendientes ahora: " + gestor.cantidadSolicitudesPendientes());

        TurnoConsulta t1 = new TurnoConsulta(e1, "Duda POO", "10:00", 15);
        TurnoConsulta t2 = new TurnoConsulta(e2, "Entrega ejercicio", "10:15", 10);

        prof1.agregarEstudianteACola(t1);
        prof1.agregarEstudianteACola(t2);

        System.out.println("\nSiguiente en cola de consultas del profesor: " + prof1.verSiguienteEnCola());
        System.out.println("Atendiendo siguiente:");
        TurnoConsulta atendido = prof1.atenderSiguienteEstudiante();
        System.out.println("Atendido: " + atendido);
    }
}
