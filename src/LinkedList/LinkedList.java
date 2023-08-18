package LinkedList;

import java.util.Iterator;

/**
 * Clase lista enlazada
 * 
 * @param <T> Generic type
 * @see Node
 * 
 * @version 1.1
 * @since 2023-06-10
 * @author meavilam@unah.hn
 */

public class LinkedList<T> implements Iterable<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList(T data) {
        this.head = new Node<T>(data);
    }

    /**
     * Agrega un elemento al final de la lista
     * 
     * @param T data
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        size++;

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    /**
     * Verifica sí la lista esta vacia
     * 
     * @return Retorna si es verdadero o falso
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Elimina un elemento de la lista enlazada según su posición
     * 
     * @param position Posición del elemento a eliminar
     * @since 2023-08-17
     */
    public void remove(int position) {
        if (position == 0) {
            this.head = this.head.getNext();
            size--;
            return;
        }

        if (position >= size) {
            System.out.println("Posición fuera de rango");
            return;
        }

        Node<T> current = this.head;
        int counter = 0;
        while (current.getNext() != null) {
            if (counter + 1 == position) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
            counter++;
        }
    }

    /**
     * Elimina un elemento de la lista enlazada según su valor
     * 
     * @param value Valor del elemento a eliminar
     * @since 2023-08-17
     */
    public void removeValue(T value) {
        if (this.head.getData() == value) {
            this.head = this.head.getNext();
            size--;
            return;
        }
        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getData() == value) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Seleciona un nodo de la lista enlazada según su posición
     * 
     * @param position Posición del elemento a seleccionar
     */
    public Node<T> get(int position) {
        if (position >= size) {
            System.out.println("Posición fuera de rango");
            return null;
        }
        Node<T> current = this.head;
        int counter = 0;
        while (current != null) {
            if (counter == position) {
                return current;
            }
            current = current.getNext();
            counter++;
        }
        return null;
    }

    /**
     * Cambia el valor de un nodo de la lista enlazada según su posición
     * 
     * @param position Posición del elemento a cambiar
     * @param value    Valor a cambiar
     */

    public void set(int position, T value) {
        if (position >= size) {
            System.out.println("Posición fuera de rango");
            return;
        }
        Node<T> current = this.head;
        int counter = 0;
        while (current != null) {
            if (counter == position) {
                current.setData(value);
                return;
            }
            current = current.getNext();
            counter++;
        }
    }

    /**
     * Retorna el primer nodo de la lista
     * 
     * @since 2023-08-18
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * Retorna el ultimo nodo de la lista
     * 
     * @since 2023-08-18
     */
    public Node<T> getTail() {
        return this.tail;
    }

    /**
     * Setea el primer nodo de la lista
     * 
     * @param node
     * @since 2023-08-18
     */
    public void setHead(Node<T> node) {
        this.head = node;
    }

    /**
     * Setea el ultimo nodo de la lista
     * 
     * @param node
     * @since 2023-08-18
     */
    public void setTail(Node<T> node) {
        this.tail = node;
    }

    /**
     * Ordena la lista de manera ascendente
     * 
     * @since 2023-08-18
     */
    public void quickSortAsc() {
        quickSortRecursive(this.head, this.tail);
        return;
    }

    /**
     * QuickSort de manera recursiva
     * 
     * @param low  Nodo inicial
     * @param high Nodo final
     * @since 2023-08-18
     */
    private void quickSortRecursive(Node<T> low, Node<T> high) {
        if (low == null || high == null || low == high || low == high.getNext()) {
            return;
        }
        Node<T> pivot = partition(low, high);
        quickSortRecursive(low, pivot.getPrev());
        quickSortRecursive(pivot.getNext(), high);
    }

    private Node<T> partition(Node<T> low, Node<T> high) {
        if (low == null || high == null) {
            return null;
        }
        
        Node<T> pivot = high;

        Node<T> i = new Node<T>(null);
        i.setNext(low);

        if(low.getPrev() != null) {
            i = low.getPrev();
        }

        Node<T> current = low;

        while(current != null && current != high) {
            if(current.getData().hashCode() < pivot.getData().hashCode() && current != null) {
                if(current.getData().hashCode() == 8){
                    System.out.println(i.getNext().getData() + " " + current.getData() + " " + pivot.getData());
                }
                i = i.getNext();
                swap(i, current);
            }
            current = current.getNext();
        }

        i = i.getNext();
        swap(i, pivot);
        pivot = i;
        return pivot;
    }

    /**
     * Intercambia los datos de dos nodos
     * 
     * @param a nodo a
     * @param b nodo b
     * 
     * @since 2023-08-18
     */
    public void swap(Node<T> a, Node<T> b) {
        T temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    /**
     * @return Iterator<T>
     * @see Iterator
     * @see LinkedList
     * 
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
