import java.util.ArrayList;

public class Profesor extends Persona implements MiembroUniversidad {

    private String especialidad;
    private int añosExperiencia;
    private ArrayList<Materia> materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad, String documento,
                    String especialidad, int añosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = new ArrayList<>();
    }

    public void asignarMateria(Materia materia) {
        materiasAsignadas.add(materia);
    }

    @Override
    public String obtenerRol() { return "Profesor"; }

    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
        return "[PROFESOR] " + getNombre() + " " + getApellido() +
                " - Especialidad: " + especialidad +
                " - Experiencia: " + añosExperiencia + " años";
    }
}
