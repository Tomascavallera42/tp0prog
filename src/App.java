public class App {
    public static void main(String[] args) {
  
        Universidad uni = new Universidad("Universidad Nacional", "Calle Falsa 123");

        Carrera carrera = new Carrera("Ingenieria en Sistemas");

        Materia m1 = new Materia("Programacion I", "PRG1", 6, 8.5);
        Materia m2 = new Materia("Matematica I", "MAT1", 8, 7.0);

 
        Estudiante e1 = new Estudiante("Juan", "Perez", 20, carrera);
        Estudiante e2 = new Estudiante("Maria", "Gomez", 19, carrera);

        e1.agregarMateria(m1);
        e1.agregarMateria(m2);

        e2.agregarMateria(new Materia("Ingles I", "ING1", 4, 9.0));

        carrera.agregarEstudiante(e1);
        carrera.agregarEstudiante(e2);

        uni.agregarCarrera(carrera);

        System.out.println("Listado de estudiantes en " + carrera.getNombre() + ":");
        carrera.listarEstudiantes();

        System.out.println("\nPromedios:");
        System.out.println(e1.getNombre() + " " + e1.getApellido() + ": " + e1.calcularPromedio());
        System.out.println(e2.getNombre() + " " + e2.getApellido() + ": " + e2.calcularPromedio());
    }
}
