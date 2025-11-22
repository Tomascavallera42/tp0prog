
public class GestorInscripciones {
    
    private Pila<SolicitudInscripcion> solicitudes;

    public GestorInscripciones() {
        solicitudes = new Pila<>();
    }

    public void agregarSolicitud(SolicitudInscripcion s) {
        solicitudes.push(s);
    }

    public SolicitudInscripcion procesarSiguienteSolicitud() {
        SolicitudInscripcion s = solicitudes.pop();
        if (s != null) s.setEstado("aprobada"); 
        return s;
    }

    public SolicitudInscripcion verSiguienteSolicitud() {
        return solicitudes.peek();
    }

    public int cantidadSolicitudesPendientes() {
        return solicitudes.size();
    }
}
