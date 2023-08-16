package LinkedList;

/**
 * Clase nodo para la lista enlazada
 * 
 * @param <T> Generic type
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-08-16
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
     * @return T data
     */
    public T getData() {
        return this.data;
    }

    /**
     * @return Node<T> next
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * @param data T
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
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