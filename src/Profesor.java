public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int añosExperiencia;
    private ListaEnlazada<Materia> materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = new ListaEnlazada<>();
    }

    public void asignarMateria(Materia materia) {
        if (materia == null) throw new IllegalArgumentException("Materia nula");
        materia.setProfesor(this);
        materiasAsignadas.agregar(materia);
    }

    public ListaEnlazada<Materia> getMateriasAsignadas() { return materiasAsignadas; }

    @Override
    public String obtenerRol() { return "Profesor"; }

    @Override
    public String obtenerInformacionCompleta() {
        return toString() + " - Especialidad: " + especialidad + " - Años: " + añosExperiencia;
    }

    @Override
    public String toString() {
        return "[PROFESOR] " + getNombre() + " " + getApellido() + " (doc: " + getDocumento() + ")";
    }
}
