
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDocumento(documento);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre invalido");
        this.nombre = nombre;
    }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) throw new IllegalArgumentException("Apellido invalido");
        this.apellido = apellido;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("Edad invalida");
        this.edad = edad;
    }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) {
        if (documento == null || documento.isEmpty()) throw new IllegalArgumentException("Documento invalido");
        this.documento = documento;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (edad: " + edad + ", doc: " + documento + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona)) return false;
        Persona p = (Persona) o;
        return this.documento.equals(p.documento);
    }

    @Override
    public int hashCode() {
        return documento.hashCode();
    }
}
