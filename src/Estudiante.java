import java.util.ArrayList;

public class Estudiante extends Persona implements MiembroUniversidad {

    private Carrera carrera;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, Carrera carrera) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    // -------------------------------
    //      PROMEDIO ITERATIVO
    // -------------------------------
    public double calcularPromedioIterativo() {
        if (materias.isEmpty()) return 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion();
        }
        return suma / materias.size();
    }

    // -------------------------------
    //      PROMEDIO RECURSIVO
    // -------------------------------
    public static double calcularPromedioRecursivo(Materia[] materias, int indice) {
        if (indice == materias.length) return 0;
        return materias[indice].getCalificacion() + calcularPromedioRecursivo(materias, indice + 1);
    }

    public double getPromedioRecursivo() {
        if (materias.isEmpty()) return 0;
        Materia[] arr = materias.toArray(new Materia[0]);
        double suma = calcularPromedioRecursivo(arr, 0);
        return suma / materias.size();
    }

    public Carrera getCarrera() { return carrera; }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return toString();
    }

    @Override
    public String toString() {
        return "[ESTUDIANTE] " + getNombre() + " " + getApellido() +
                " - Carrera: " + carrera.getNombre() +
                " - Promedio: " + calcularPromedioIterativo();
    }
}
