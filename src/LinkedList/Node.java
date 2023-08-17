package LinkedList;

/**
 * Clase nodo para la lista enlazada
 * 
 * @param <T> Generic type
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-06-10
 * @see LinkedList
 */

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Obtiene el dato del nodo
     * 
     * @return T data
     */
    public T getData() {
        return this.data;
    }

    /**
     * Obtiene el siguiente nodo
     * 
     * @return Node<T> next
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Modifica el valor del nodo
     * 
     * @param data T
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Cambia el nodo siguiente
     * 
     * @param next Node<T>
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.data == null) {
            return "null";
        }
        return this.data.toString();
    }
}