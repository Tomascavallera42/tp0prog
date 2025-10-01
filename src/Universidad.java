import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private String direccion;
    private ArrayList<Carrera> carreras;

    public Universidad(String nombre, String direccion) {
        setNombre(nombre);
        setDireccion(direccion);
        this.carreras = new ArrayList<>();
    }

    public void agregarCarrera(Carrera c) {
        carreras.add(c);
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre invalido");
        this.nombre = nombre;
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) throw new IllegalArgumentException("Direccion invalida");
        this.direccion = direccion;
    }

    public ArrayList<Carrera> getCarreras() { return carreras; }
}
