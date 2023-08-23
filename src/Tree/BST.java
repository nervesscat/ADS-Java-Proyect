package Tree;

import LinkedList.LinkedList;

/**
 * @author meavilam@unah.hn
 * @version 1.2
 * @since 2023-07-5
 */

public class BST {
    private Node root;
    private String content;

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {
        root = null;
        content = "";
    }

    /**
     * Inserta un nuevo nodo con el valor dado
     * 
     * @param value Valor a insertar
     */

    public void insert(int value) {
        content += value + ",";
        root = insertRecursive(root, value);
    }

    
    /**
     * Inserta un nuevo nodo con el valor dado
     * 
     * @param current Nodo actual
     * @param value Valor a insertar
     */
    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    /**
     * Busca a un nodo con un valor dado
     * 
     * @param value Valor a buscar
     * @return Verdadero si el valor es encontrado, falso de lo contrario
     */
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    /**
     * Busca a un nodo con un valor dado
     * 
     * @param current Nodo actual
     * @param value Valor a buscar
     * @return Verdadero si el valor es encontrado, falso de lo contrario
     */
    private boolean searchRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        } else if (value < current.value) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

    /**
     * Imprime el arbol en orden recursivamente
     * 
     * @param node Nodo actual
     * @param tab Tabulador
     * 
     * @since 2023-8-18
     */
    public void printTree(Node node, String tab) {
        if (node == null) {
            return;
        }

        printTree(node.right, tab + "\t");
        System.out.println(tab + node.value);
        printTree(node.left, tab + "\t");
    }

    /**
     * Imprime el arbol en orden
     * 
     * @param node Nodo actual
     * 
     * @since 2023-8-18
     */
    public void printTree(Node node) {
        printTree(node, "");
    }

    /**
     * Imprime el arbol en orden empezando desde la raiz
     * 
     * @since 2023-8-18
     */
    public void printTree(){
        printTree(root);
    }

    /**
     * Elimina un valor del arbol iniciando desde la raiz
     * 
     * @param value Valor a borrar
     * 
     * @since 2023-8-18
     */
    public void remove(int value) {
        content = content.replace(value + ",", "");
        root = removeRecursive(root, value);
    }

    /**
     * Elimina recursivamente un valor del arbol
     * 
     * @param root Nodo actual
     * @since 2023-8-18
     */
    private Node removeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = removeRecursive(current.left, value);
            return current;
        }

        current.right = removeRecursive(current.right, value);
        return current;
    }

    /**
     * Crea una lista (linkedlist) con los valores externos del arbol
     * 
     * @return Lista con los valores externos del arbol
     * @since 2023-8-18
     */
    public LinkedList<Integer> getExternalValues() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        getExternalValues(root, list);
        return list;
    }

    /**
     * Crea una lista (linkedlist) con los valores externos del arbol
     * 
     * @param node Nodo actual
     * @param list Lista con los valores externos del arbol
     */
    private void getExternalValues(Node node, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.value);
        }

        getExternalValues(node.left, list);
        getExternalValues(node.right, list);
    }

    /**
     * Encuentra el valor mas pequeño en el arbol
     * 
     * @return Valor mas pequeño en el arbol
     * @since 2023-8-17
     */
    public int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    /**
     * Encuentra el valor mas grande en el arbol
     * 
     * @return Valor mas grande en el arbol
     * @since 2023-8-17
     */
    public int findLargestValue(Node root) {
        return root.right == null ? root.value : findLargestValue(root.right);
    }

    /**
     * Encuentra el valor mas pequeño en el arbol
     * 
     * @return Valor mas pequeño en el arbol
     * @since 2023-8-17
     */
    public int findSmallestValue() {
        return findSmallestValue(root);
    }

    /**
     * Encuentra el valor mas grande en el arbol
     * 
     * @return Valor mas grande en el arbol
     * @since 2023-8-17
     */
    public int findLargestValue() {
        return findLargestValue(root);
    }

    /**
     * Encuentra la altura del arbol
     * 
     * @return Altura del arbol
     * @since 2023-8-17
     */
    public int height() {
        return height(root);
    }

    /**
     * Encuentra la altura del arbol
     * 
     * @param node Nodo actual
     * @since 2023-8-17
     * @return Altura del arbol
     */
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * ToString del arbol
     * @since 2023-8-21
     */
    public String toString() {
        return content;
    }
}

