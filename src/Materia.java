public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;

    public Materia(String nombre, String codigo, int creditos, double calificacion) {
        setNombre(nombre);
        setCodigo(codigo);
        setCreditos(creditos);
        setCalificacion(calificacion);
    }

    // Getters y Setters con validaciones
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre de materia invalido");
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) throw new IllegalArgumentException("Codigo invalido");
        this.codigo = codigo;
    }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) {
        if (creditos <= 0) throw new IllegalArgumentException("Creditos deben ser mayores a 0");
        this.creditos = creditos;
    }

    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) {
        if (calificacion < 0 || calificacion > 10) throw new IllegalArgumentException("La calificacion debe estar entre 0 y 10");
        this.calificacion = calificacion;
    }
}
