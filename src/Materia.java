public class Materia {
    private String nombre;
    private double calificacion;
    private Profesor profesor;

    public Materia(String nombre, double calificacion, Profesor profesor) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre materia invalido");
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    public String getNombre() { return nombre; }
    public double getCalificacion() { return calificacion; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor p) { this.profesor = p; }

    @Override
    public String toString() {
        return nombre + " (" + calificacion + ") - Prof: " + (profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "Sin profesor");
    }
}
