public class Materia {
    private String nombre;
    private double calificacion;
    private Profesor profesor;

    public Materia(String nombre, double calificacion, Profesor profesor) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    public String getNombre() { return nombre; }
    public double getCalificacion() { return calificacion; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor p) { this.profesor = p; }
}
