import java.util.ArrayList;

public class Universidad {

    private ArrayList<MiembroUniversidad> miembros = new ArrayList<>();

    public void agregarMiembro(MiembroUniversidad m) {
        miembros.add(m);
    }

    public void listarMiembros() {
        for (MiembroUniversidad m : miembros) {
            System.out.println(m.obtenerInformacionCompleta());
        }
    }

  
    public static int contarEstudiantesRecursivo(Estudiante[] est, String carrera, int i) {
        if (i == est.length) return 0;
        int suma = est[i].getCarrera().getNombre().equals(carrera) ? 1 : 0;
        return suma + contarEstudiantesRecursivo(est, carrera, i + 1);
    }

    public static int contarEstudiantesIterativo(Estudiante[] est, String carrera) {
        int c = 0;
        for (Estudiante e : est) {
            if (e.getCarrera().getNombre().equals(carrera)) c++;
        }
        return c;
    }

  
    public static Estudiante buscarEstudianteRecursivo(Estudiante[] est, String dni, int i) {
        if (i == est.length) return null;
        if (est[i].getDocumento().equals(dni)) return est[i];
        return buscarEstudianteRecursivo(est, dni, i + 1);
    }

    public static Estudiante buscarEstudianteIterativo(Estudiante[] est, String dni) {
        for (Estudiante e : est) {
            if (e.getDocumento().equals(dni)) return e;
        }
        return null;
    }

   
    public static void ordenarEstudiantesPorApellido(Estudiante[] est) {
        int n = est.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (est[j].getApellido().compareTo(est[min].getApellido()) < 0) {
                    min = j;
                }
            }

            if (min != i) {
                Estudiante temp = est[i];
                est[i] = est[min];
                est[min] = temp;
            }
        }
    }

   
    public static int busquedaBinariaEstudiantes(Estudiante[] est, String apellido) {
        ordenarEstudiantesPorApellido(est);

        int inicio = 0, fin = est.length - 1;

        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;

            int comp = est[mid].getApellido().compareTo(apellido);

            if (comp == 0) return mid;
            if (comp < 0) inicio = mid + 1;
            else fin = mid - 1;
        }
        return -1;
    }
}
