import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private Carrera carrera;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, Carrera carrera) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        this.carrera = carrera;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Materia m) {
        materias.add(m);
    }

    public double calcularPromedio() {
        if (materias.isEmpty()) return 0;
        double suma = 0;
        for (Materia m : materias) {
            suma += m.getCalificacion();
        }
        return suma / materias.size();
    }

    // Getters y Setters con validaciones
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre invalido");
        this.nombre = nombre;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) throw new IllegalArgumentException("Apellido invalido");
        this.apellido = apellido;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 16) throw new IllegalArgumentException("La edad debe ser mayor o igual a 16");
        this.edad = edad;
    }

    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }

    public ArrayList<Materia> getMaterias() { return materias; }
}
