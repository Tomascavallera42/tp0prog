public class Estudiante extends Persona implements MiembroUniversidad {
    private String carreraNombre;
    private ListaEnlazada<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, String carreraNombre) {
        super(nombre, apellido, edad, documento);
        this.carreraNombre = carreraNombre;
        this.materias = new ListaEnlazada<>();
    }

    public void agregarMateria(Materia m) {
        if (m == null) throw new IllegalArgumentException("Materia nula");
        materias.agregar(m);
    }

    public double calcularPromedioIterativo() {
        ListaEnlazada.Nodo<Materia> actual = materias.getPrimero();
        if (actual == null) return 0;
        double suma = 0;
        int contador = 0;
        while (actual != null) {
            suma += actual.dato.getCalificacion();
            contador++;
            actual = actual.siguiente;
        }
        return contador == 0 ? 0 : suma / contador;
    }

    public static double calcularPromedioRecursivoWrapper(ListaEnlazada<Materia> lista) {
        return calcularPromedioRecursivo(lista.getPrimero(), 0, 0.0);
    }

  
    public static double calcularPromedioRecursivo(ListaEnlazada.Nodo<Materia> actual, int contador, double suma) {
        if (actual == null) {
            return contador == 0 ? 0 : suma / contador;
        }
        return calcularPromedioRecursivo(actual.siguiente, contador + 1, suma + actual.dato.getCalificacion());
    }

    public ListaEnlazada<Materia> getMaterias() { return materias; }

    public String getCarreraNombre() { return carreraNombre; }
    public void setCarreraNombre(String carreraNombre) { this.carreraNombre = carreraNombre; }

    @Override
    public String obtenerRol() { return "Estudiante"; }

    @Override
    public String obtenerInformacionCompleta() {
        return toString() + " - Carrera: " + carreraNombre + " - Promedio(iter): " + calcularPromedioIterativo();
    }

    @Override
    public String toString() {
        return "[ESTUDIANTE] " + getNombre() + " " + getApellido() + " (doc: " + getDocumento() + ")";
    }
}
