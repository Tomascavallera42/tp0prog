public class ListaEnlazada<T> {
    public static class Nodo<U> {
        public U dato;
        public Nodo<U> siguiente;
        public Nodo(U dato) { this.dato = dato; this.siguiente = null; }
    }

    private Nodo<T> primero;
    private int tamaño;

    public ListaEnlazada() {
        primero = null;
        tamaño = 0;
    }

    public void agregar(T dato) {
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

    public void agregarOrdenado(T dato, java.util.Comparator<T> cmp) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null || cmp.compare(dato, primero.dato) <= 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null && cmp.compare(dato, actual.siguiente.dato) > 0) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public Nodo<T> getPrimero() { return primero; }
    public int size() { return tamaño; }
    public boolean isEmpty() { return tamaño == 0; }

    
    public Object[] toArray() {
        Object[] arr = new Object[tamaño];
        Nodo<T> actual = primero;
        int i = 0;
        while (actual != null) {
            arr[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return arr;
    }


    public void rebuildFromArray(Object[] array) {
        primero = null;
        tamaño = 0;
        for (int i = 0; i < array.length; i++) {
            @SuppressWarnings("unchecked")
            T dato = (T) array[i];
            agregar(dato);
        }
    }

  
    public ListaEnlazada.Nodo<T> buscarNodoPorDocumento(String documento) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.dato instanceof Persona) {
                Persona p = (Persona) actual.dato;
                if (p.getDocumento().equals(documento)) return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
