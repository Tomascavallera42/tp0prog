public class Carrera {
    private String nombre;
    private ListaEnlazada<Estudiante> estudiantes;

    public Carrera(String nombre) {
        setNombre(nombre);
        this.estudiantes = new ListaEnlazada<>();
    }

    public void agregarEstudiante(Estudiante e) {
        if (e == null) throw new IllegalArgumentException("Estudiante nulo");
        // insertamos ordenado por apellido (opcional)
        estudiantes.agregarOrdenado(e, (a, b) -> {
            Estudiante ea = (Estudiante) a;
            Estudiante eb = (Estudiante) b;
            return ea.getApellido().compareToIgnoreCase(eb.getApellido());
        });
    }

    public void listarEstudiantes() {
        ListaEnlazada.Nodo<Estudiante> actual = estudiantes.getPrimero();
        while (actual != null) {
            Estudiante e = actual.dato;
            System.out.println(e.getNombre() + " " + e.getApellido() + " - Edad: " + e.getEdad());
            actual = actual.siguiente;
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre de carrera invalido");
        this.nombre = nombre;
    }

    public ListaEnlazada<Estudiante> getEstudiantes() { return estudiantes; }
}
