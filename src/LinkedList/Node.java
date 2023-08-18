package LinkedList;

/**
 * Clase nodo para la lista enlazada
 * 
 * @param <T> Generic type
 * @author meavilam@unah.hn
 * @version 1.1
 * @since 2023-06-10
 * @see LinkedList
 */

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
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
     * Establece el dato del nodo
     * 
     * @param T data
     */
    public void setData(T data) {
        this.data = data;
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
     * Establece el siguiente nodo
     * @param Node<T> next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior
     * 
     * @return Node<T> prev
     * @since 2023-08-17
     */
    public Node<T> getPrev() {
        return this.prev;
    }

    /**
     * Establece el nodo anterior
     * 
     * @param Node<T> prev
     * @since 2023-08-17
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        if (this.data == null) {
            return "null";
        }
        return this.data.toString();
    }
}