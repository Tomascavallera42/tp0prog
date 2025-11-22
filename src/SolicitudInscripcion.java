
import java.time.LocalDateTime;

public class SolicitudInscripcion {
    private Estudiante estudiante;
    private Materia materia;
    private LocalDateTime fechaSolicitud;
    private String estado;

    public SolicitudInscripcion(Estudiante estudiante, Materia materia) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "pendiente";
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Materia getMateria() { return materia; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "[" + fechaSolicitud + "] " + estudiante.getNombre() + " " + estudiante.getApellido()
                + " -> " + materia.getNombre() + " (" + estado + ")";
    }
}
