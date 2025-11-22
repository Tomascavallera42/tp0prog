// Profesor.java
public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int añosExperiencia;
    private ListaEnlazada<Materia> materiasAsignadas;
    private Cola<TurnoConsulta> colaConsultas; // opción d: cola para turnos

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = new ListaEnlazada<>();
        this.colaConsultas = new Cola<>();
    }

    public void asignarMateria(Materia m) {
        materiasAsignadas.agregarAlFinal(m);
        m.setProfesor(this);
    }

    public void agregarEstudianteACola(TurnoConsulta turno) {
        colaConsultas.enqueue(turno);
    }

    public TurnoConsulta atenderSiguienteEstudiante() {
        return colaConsultas.dequeue();
    }

    public TurnoConsulta verSiguienteEnCola() {
        return colaConsultas.peek();
    }

    @Override
    public String obtenerRol() { return "Profesor"; }

    @Override
    public String obtenerInformacionCompleta() {
        return "[PROFESOR] " + toString();
    }

    @Override
    public String toString() {
        return super.toString() + " - Esp: " + especialidad + " - Años: " + añosExperiencia;
    }
}
