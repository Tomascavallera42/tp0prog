
public class Pila<T> {
    private ListaEnlazada<T> lista;

    public Pila() {
        lista = new ListaEnlazada<>();
    }

    public void push(T dato) {
        // insertar al inicio para O(1)
        lista.agregarAlInicio(dato);
    }

    public T pop() {
        return lista.quitarInicio();
    }

    public T peek() {
        Nodo<T> primero = lista.getPrimero();
        return (primero == null) ? null : primero.dato;
    }

    public boolean isEmpty() {
        return lista.estaVacia();
    }

    public int size() {
        return lista.tamaño();
    }
}
