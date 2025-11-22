
public class ListaEnlazada<T> {
    private Nodo<T> primero;
    private int tamaño;

    public ListaEnlazada() {
        primero = null;
        tamaño = 0;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = primero;
        primero = nuevo;
        tamaño++;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int tamaño() {
        return tamaño;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public T quitarInicio() {
        if (primero == null) return null;
        T dato = primero.dato;
        primero = primero.siguiente;
        tamaño--;
        return dato;
    }

    public T obtenerEnIndice(int indice) {
        if (indice < 0 || indice >= tamaño) return null;
        Nodo<T> actual = primero;
        int i = 0;
        while (i < indice) {
            actual = actual.siguiente;
            i++;
        }
        return actual.dato;
    }

    public Object[] convertirAArray() {
        Object[] arr = new Object[tamaño];
        Nodo<T> actual = primero;
        int i = 0;
        while (actual != null) {
            arr[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return arr;
    }

    public void limpiar() {
        primero = null;
        tamaño = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        sb.append("[");
        while (actual != null) {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if (actual != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
