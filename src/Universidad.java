// Universidad.java
public class Universidad {
    private ListaEnlazada<MiembroUniversidad> miembros;

    public Universidad() {
        miembros = new ListaEnlazada<>();
    }

    public void agregarMiembro(MiembroUniversidad m) {
        // sugerencia: insertar al final
        miembros.agregarAlFinal(m);
    }

    public void listarMiembros() {
        Nodo<MiembroUniversidad> n = miembros.getPrimero();
        while (n != null) {
            MiembroUniversidad m = n.dato;
            System.out.println(m.obtenerInformacionCompleta());
            n = n.siguiente;
        }
    }

    // Ejemplo: buscar recursivo por documento (usa Nodo)
    public static Estudiante buscarEstudianteRecursivoNodo(Nodo<MiembroUniversidad> nodo, String documento) {
        if (nodo == null) return null;
        MiembroUniversidad m = nodo.dato;
        if (m instanceof Estudiante) {
            Estudiante e = (Estudiante) m;
            if (e.getDocumento().equals(documento)) return e;
        }
        return buscarEstudianteRecursivoNodo(nodo.siguiente, documento);
    }

    public Nodo<MiembroUniversidad> getMiembrosNodo() {
        return miembros.getPrimero();
    }
}
