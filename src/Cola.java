// Cola.java
public class Cola<T> {
    private ListaEnlazada<T> lista;

    public Cola() {
        lista = new ListaEnlazada<>();
    }

    public void enqueue(T dato) {
        lista.agregarAlFinal(dato);
    }

    public T dequeue() {
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
