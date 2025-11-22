
public class Carrera {
    private String nombre;
    private ListaEnlazada<Estudiante> estudiantes;

    public Carrera(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre de carrera invalido");
        this.nombre = nombre;
        this.estudiantes = new ListaEnlazada<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.agregarAlFinal(e);
    }

    public ListaEnlazada<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() { return nombre; }

    public void listarEstudiantes() {
        Nodo<Estudiante> n = estudiantes.getPrimero();
        while (n != null) {
            Estudiante e = n.dato;
            System.out.println(e.getNombre() + " " + e.getApellido() + " - Edad: " + e.getEdad());
            n = n.siguiente;
        }
    }
}
