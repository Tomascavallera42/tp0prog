public class App {
    public static void main(String[] args) {
        Universidad univ = new Universidad();

        Carrera sistemas = new Carrera("Sistemas");

        Profesor prof1 = new Profesor("Laura", "Gomez", 45, "22334455", "Programacion", 20);

        Estudiante e1 = new Estudiante("Tomas", "Cavallera", 20, "44999888", "Sistemas");
        Estudiante e2 = new Estudiante("Juan", "Perez", 21, "40987654", "Sistemas");
        Estudiante e3 = new Estudiante("Ana", "Alvarez", 22, "40123456", "Sistemas");

        // Materias
        Materia m1 = new Materia("POO", 9.0, prof1);
        Materia m2 = new Materia("Algoritmos", 8.0, prof1);
        Materia m3 = new Materia("Sistemas Operativos", 7.5, prof1);

       
        prof1.asignarMateria(m1);
        prof1.asignarMateria(m2);
        prof1.asignarMateria(m3);

  
        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        e2.agregarMateria(m2);
        e2.agregarMateria(m3);

        e3.agregarMateria(m1);
        e3.agregarMateria(m3);

        sistemas.agregarEstudiante(e1);
        sistemas.agregarEstudiante(e2);
        sistemas.agregarEstudiante(e3);

        univ.agregarMiembro(e1);
        univ.agregarMiembro(e2);
        univ.agregarMiembro(e3);
        univ.agregarMiembro(prof1);
        univ.agregarMiembro(new Personal("Mariana", "Lopez", 35, "33445566", "Administracion", "Recepcion", "2020-03-01"));

        System.out.println("---- LISTA DE MIEMBROS (POLIMORFISMO) ----");
        univ.listarMiembros();

        System.out.println("\n---- PROMEDIO (iterativo/recursivo) ----");
        System.out.println(e1.getNombre() + " promedio iterativo: " + e1.calcularPromedioIterativo());
        System.out.println(e1.getNombre() + " promedio recursivo: " + Estudiante.calcularPromedioRecursivoWrapper(e1.getMaterias()));

        System.out.println("\n---- CONTAR ESTUDIANTES POR CARRERA ----");
        System.out.println("Estudiantes en Sistemas (recursivo): " + univ.contarEstudiantesRecursivoWrapper("Sistemas"));
        System.out.println("Estudiantes en Sistemas (iterativo): " + univ.contarEstudiantesIterativo("Sistemas"));

        System.out.println("\n---- BUSCAR ESTUDIANTE POR DOCUMENTO ----");
        Estudiante buscado = univ.buscarEstudianteRecursivoWrapper("40987654");
        System.out.println("Buscado (recursivo): " + (buscado != null ? buscado.obtenerInformacionCompleta() : "No encontrado"));

        Estudiante buscado2 = univ.buscarEstudianteIterativo("40123456");
        System.out.println("Buscado (iterativo): " + (buscado2 != null ? buscado2.obtenerInformacionCompleta() : "No encontrado"));

        System.out.println("\n---- ORDENAR ESTUDIANTES POR APELLIDO (DE CARRERA) ----");
        System.out.println("Antes (Carrera.listarEstudiantes):");
        sistemas.listarEstudiantes();

        System.out.println("\nAplicando ordenamiento por apellido (selection sort sobre array convertido):");
        univ.ordenarEstudiantesPorApellido(sistemas.getEstudiantes());

        System.out.println("Después:");
        sistemas.listarEstudiantes();

        System.out.println("\n---- BUSQUEDA BINARIA POR APELLIDO ----");
        Estudiante[] arr = Universidad.listaAArray(sistemas.getEstudiantes());
        // array ya ordenado por apellido
        int idx = Universidad.busquedaBinariaEstudiantes(arr, "Perez");
        System.out.println("Indice de 'Perez' en array ordenado: " + idx);
        if (idx != -1) System.out.println("Encontrado: " + arr[idx].obtenerInformacionCompleta());
    }
}
