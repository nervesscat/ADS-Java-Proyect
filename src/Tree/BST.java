package Tree;

/**
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-07-5
 */

public class BST {
    private Node root;

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
    }

    /**
     * Inserta un nuevo nodo con el valor dado
     * 
     * @param value Valor a insertar
     */

    public void insert(int value) {
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


    public void printTree(Node node, String tab) {
        if (node == null) {
            return;
        }

        printTree(node.right, tab + "\t");
        System.out.println(tab + node.value);
        printTree(node.left, tab + "\t");
    }

    public void printTree(Node node) {
        printTree(node, "");
    }

    public void printTree(){
        printTree(root);
    }
}

