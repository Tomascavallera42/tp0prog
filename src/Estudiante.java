
public class Estudiante extends Persona implements MiembroUniversidad {
    private Carrera carrera;
    private ListaEnlazada<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, Carrera carrera) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = new ListaEnlazada<>();
    }

    public void agregarMateria(Materia m) {
        materias.agregarAlFinal(m);
    }

    public double calcularPromedioIterativo() {
        Nodo<Materia> actual = materias.getPrimero();
        if (actual == null) return 0;
        double suma = 0;
        int contador = 0;
        while (actual != null) {
            suma += actual.dato.getCalificacion();
            contador++;
            actual = actual.siguiente;
        }
        return (contador == 0) ? 0 : suma / contador;
    }


    public static double calcularPromedioRecursivoNodo(Nodo<Materia> nodo) {
        return calcularPromedioRecursivo(nodo, 0, 0.0);
    }

    private static double calcularPromedioRecursivo(Nodo<Materia> nodo, int contador, double suma) {
        if (nodo == null) {
            return (contador == 0) ? 0 : suma / contador;
        }
        return calcularPromedioRecursivo(nodo.siguiente, contador + 1, suma + nodo.dato.getCalificacion());
    }

    public ListaEnlazada<Materia> getMaterias() { return materias; }
    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera c) { this.carrera = c; }

    @Override
    public String obtenerRol() { return "Estudiante"; }

    @Override
    public String obtenerInformacionCompleta() {
        return "[ESTUDIANTE] " + toString();
    }

    @Override
    public String toString() {
        return super.toString() + " - Carrera: " + (carrera != null ? carrera.getNombre() : "N/A");
    }
}
