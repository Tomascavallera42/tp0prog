import java.util.Arrays;
import java.util.Comparator;

public class Universidad {
    private ListaEnlazada<MiembroUniversidad> miembros;

    public Universidad() {
        miembros = new ListaEnlazada<>();
    }

    public void agregarMiembro(MiembroUniversidad m) {
        if (m == null) throw new IllegalArgumentException("Miembro nulo");
       
        if (m instanceof Estudiante) {
          
            miembros.agregarOrdenado(m, (a, b) -> {
                Persona pa = (Persona) a;
                Persona pb = (Persona) b;
                return pa.getApellido().compareToIgnoreCase(pb.getApellido());
            });
        } else {
            miembros.agregar(m);
        }
    }

    public void listarMiembros() {
        ListaEnlazada.Nodo<MiembroUniversidad> actual = miembros.getPrimero();
        while (actual != null) {
            MiembroUniversidad m = actual.dato;
            System.out.println(m.obtenerInformacionCompleta());
            actual = actual.siguiente;
        }
    }

    public int contarEstudiantesRecursivoWrapper(String carrera) {
        return contarEstudiantesRecursivo(miembros.getPrimero(), carrera);
    }

    private int contarEstudiantesRecursivo(ListaEnlazada.Nodo<MiembroUniversidad> actual, String carrera) {
        if (actual == null) return 0;
        int suma = 0;
        MiembroUniversidad m = actual.dato;
        if (m instanceof Estudiante) {
            Estudiante e = (Estudiante) m;
            if (e.getCarreraNombre().equalsIgnoreCase(carrera)) suma = 1;
        }
        return suma + contarEstudiantesRecursivo(actual.siguiente, carrera);
    }

  
    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        ListaEnlazada.Nodo<MiembroUniversidad> actual = miembros.getPrimero();
        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                Estudiante e = (Estudiante) actual.dato;
                if (e.getCarreraNombre().equalsIgnoreCase(carrera)) contador++;
            }
            actual = actual.siguiente;
        }
        return contador;
    }


    public Estudiante buscarEstudianteRecursivoWrapper(String documento) {
        return buscarEstudianteRecursivo(miembros.getPrimero(), documento);
    }

    private Estudiante buscarEstudianteRecursivo(ListaEnlazada.Nodo<MiembroUniversidad> actual, String documento) {
        if (actual == null) return null;
        MiembroUniversidad m = actual.dato;
        if (m instanceof Estudiante) {
            Estudiante e = (Estudiante) m;
            if (e.getDocumento().equals(documento)) return e;
        }
        return buscarEstudianteRecursivo(actual.siguiente, documento);
    }

 
    public Estudiante buscarEstudianteIterativo(String documento) {
        ListaEnlazada.Nodo<MiembroUniversidad> actual = miembros.getPrimero();
        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                Estudiante e = (Estudiante) actual.dato;
                if (e.getDocumento().equals(documento)) return e;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void ordenarEstudiantesPorApellido(ListaEnlazada<Estudiante> listaEstudiantes) {
        Object[] arr = listaEstudiantes.toArray();
       
        Estudiante[] estudiantes = new Estudiante[arr.length];
        for (int i = 0; i < arr.length; i++) estudiantes[i] = (Estudiante) arr[i];


        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareToIgnoreCase(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }

      
        Object[] nuevo = new Object[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) nuevo[i] = estudiantes[i];
        listaEstudiantes.rebuildFromArray(nuevo);
    }

    
    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        int izquierda = 0, derecha = estudiantes.length - 1;
        while (izquierda <= derecha) {
            int mid = (izquierda + derecha) / 2;
            int cmp = estudiantes[mid].getApellido().compareToIgnoreCase(apellido);
            if (cmp == 0) return mid;
            if (cmp < 0) izquierda = mid + 1;
            else derecha = mid - 1;
        }
        return -1;
    }

    public static Estudiante[] listaAArray(ListaEnlazada<Estudiante> lista) {
        Object[] arr = lista.toArray();
        Estudiante[] res = new Estudiante[arr.length];
        for (int i = 0; i < arr.length; i++) res[i] = (Estudiante) arr[i];
        return res;
    }

    public ListaEnlazada<MiembroUniversidad> getMiembros() { return miembros; }
}
