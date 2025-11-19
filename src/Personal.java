public class Personal extends Persona implements MiembroUniversidad {
    private String departamento;
    private String puesto;
    private String fechaIngreso;

    public Personal(String nombre, String apellido, int edad, String documento,
                    String departamento, String puesto, String fechaIngreso) {
        super(nombre, apellido, edad, documento);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String obtenerRol() { return "Personal"; }

    @Override
    public String obtenerInformacionCompleta() { return toString(); }

    @Override
    public String toString() {
        return "[PERSONAL] " + getNombre() + " " + getApellido() +
                " - Departamento: " + departamento +
                " - Puesto: " + puesto +
                " - Ingreso: " + fechaIngreso;
    }
}
