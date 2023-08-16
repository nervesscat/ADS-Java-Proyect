package LinkedList;

import java.util.Iterator;

/**
 * Clase lista enlazada
 * 
 * @param <T> Generic type
 * @see Node
 * 
 * @version 1.0
 * @since 2023-08-16
 */

public class LinkedList<T> implements Iterable<T> {
    
    private Node<T> head;
    private int size = 0;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList(T data) {
        this.head = new Node<T>(data);
    }


    /**
     * @param data T
     */
    public void add(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            size++;
            return;
        }
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<T>(data));
        size++;
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean itExists(T data) {
        if (this.head == null) {
            return false;
        }
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * @param data T
     */
    public void add(Node<T> node) {
        if (this.head == null) {
            this.head = node;
            size++;
            return;
        }
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    /**
     * @return int size
     */
    public int size() {
        return this.size;
    }

    /**
     * @return Iterator<T>
     * @see Iterator
     * @see LinkedList
     * 
     * @since 2023-08-16
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            sb.append(current.toString());
            sb.append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
