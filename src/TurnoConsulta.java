
public class TurnoConsulta {
    private Estudiante estudiante;
    private String motivo;
    private String horaLlegada;
    private int duracionEstimadaMin;

    public TurnoConsulta(Estudiante estudiante, String motivo, String horaLlegada, int duracionEstimadaMin) {
        this.estudiante = estudiante;
        this.motivo = motivo;
        this.horaLlegada = horaLlegada;
        this.duracionEstimadaMin = duracionEstimadaMin;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public String getMotivo() { return motivo; }
    public String getHoraLlegada() { return horaLlegada; }
    public int getDuracionEstimadaMin() { return duracionEstimadaMin; }

    @Override
    public String toString() {
        return estudiante.getNombre() + " " + estudiante.getApellido() + " - " + motivo + " (" + horaLlegada + ")";
    }
}
