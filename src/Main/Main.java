package Main;

import java.util.Scanner;

import Graph.Graph;
import LinkedList.LinkedList;
import Tree.BST;

public class Main {
    public static void main(String[] args){
        String welcomeMSG = "\u001B[35m\u2554═══════════════════════════════════════\u2557\n" +
                    "║                                       ║\n" +
                    "║   \u001B[36m     \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2557   \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u001B[35m   ║\n" +
                    "║   \u001B[36m     \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u001B[35m   ║\n" +
                    "║   \u001B[36m     \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u001B[35m   ║\n" +
                    "║   \u001B[36m\u2588\u2588   \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u255A\u2588\u2588\u2557 \u2588\u2588\u2554\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551  \u001B[35m ║\n" +
                    "║   \u001B[36m\u255A\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551  \u2588\u2588\u2551 \u255A\u2588\u2588\u2588\u2588\u2554\u255D \u2588\u2588\u2551  \u2588\u2588\u2551\u001B[35m   ║\n" +
                    "║   \u001B[36m \u255A\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u2550\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u255D\u001B[35m   ║\n" +
                    "║                                       ║\n" +
                    "║   \u001B[33mADS Java Project v 0.1\u001B[35m              ║\n" +
                    "║   \u001B[33mA program to manipulate LinkedLists,\u001B[35m║\n" +
                    "║   \u001B[33mMaps, and Graphs. Created by: \u001B[35m      ║\n" +
                    "║   \u001B[33m@author meavilam@unah.hn \u001B[35m           ║\n" +
                    "║                                       ║\n" +
                    "\u001B[35m\u255A═══════════════════════════════════════\u255D\n\u001B[0m";

        System.out.println(welcomeMSG);

        LinkedList<Integer> list = new LinkedList<Integer>();
        BST tree = new BST();
        Graph<String> graph = new Graph<String>();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("> ");
            String cmd = sc.nextLine();
            
            String[] key = cmd.split(" ");

            //* -------------- LinkedList -------------- *// 
            if(key[0].equals("linkedlist") && key.length == 1){ System.out.println(list); }

            if (key[0].equals("linkedlist") && key.length > 2 && key[1].equals("push")){
                String[] pushItems = key[2].split(",");
                for(String value : pushItems){
                    list.add(Integer.parseInt(value));
                }
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("pop") && key[2].equals("position")){
                list.remove(Integer.parseInt(key[3]));
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("pop") && key[2].equals("value")){
                list.removeValue(Integer.parseInt(key[3]));
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("order") && key[2].equals("quicksort") && key[3].equals("asc")){
                list.quickSortAsc();
                System.out.println(list);
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("order") && key[2].equals("quicksort") && key[3].equals("desc")){
                list.quickSortDesc();
                System.out.println(list);
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("order") && key[2].equals("mergesort") && key[3].equals("asc")){
                list.mergeSortAsc();
                System.out.println(list);
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 4 && key[1].equals("order") && key[2].equals("mergesort") && key[3].equals("desc")){
                list.mergeSortDesc();
                System.out.println(list);
                continue;
            }

            if(key[0].equals("linkedlist") && key.length == 2 && key[1].equals("help")){
                System.out.println("\u001B[36mMenú de ayuda LinkedList\u001B[0m\n" +
                "\u001B[35mlinkedlist push <values>\u001B[0m : agrega un valor a la lista enlazada. El valor a agregar puede ser uno o m\u00FAltiples elementos separados por comas. Eg. linkedlist push 1,2,3,4,5,6\n" +
                "\u001B[35mlinkedlist pop position\u001B[0m : elimina el valor de una posición de la lista.\n" +
                "\u001B[35mlinkedlist pop value\u001B[0m : elimina el elemento que coincide con el valor entregado.\n" +
                "\u001B[35mlinkedlist order quicksort asc\u001B[0m : imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.\n" +
                "\u001B[35mlinkedlist order quicksort desc\u001B[0m : imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mencin.\n" +
                "\u001B[35mlinkedlist order mergesort asc\u001B[0m : imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.\n" +
                "\u001B[35mlinkedlist order mergesort desc\u001B[0m : imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mención.\n" + 
                "\u001B[35mlinkedlist\u001B[0m : imprime el contenido de la lista enlazada."
                );
                continue;
            }

            if(key[0].equals("linkedlist") && key.length != 1){ 
                System.out.println("\u001B[31mFaltan argumentos, linkedlist help para mas información\u001B[0m"); 
                continue;
            }

            //* -------------- Tree -------------- *// 

            if(key[0].equals("tree") && key.length == 1) { 
                tree.printTree(); 
            }

            if(key[0].equals("tree") && key.length > 2 &&  key[1].equals("push")){
                String[] pushItems = key[2].split(",");
                for(String value : pushItems){
                    tree.insert(Integer.parseInt(value));
                }
                continue;
            }

            if(key[0].equals("tree") && key.length == 3 && key[1].equals("remove")){
                tree.remove(Integer.parseInt(key[2]));
                continue;
            }

            if(key[0].equals("tree") && key.length == 2 && key[1].equals("greatest")){
                System.out.println(tree.findLargestValue());
                continue;
            }

            if(key[0].equals("tree") && key.length == 2 && key[1].equals("smallest")){
                System.out.println(tree.findSmallestValue());
                continue;
            }

            if(key[0].equals("tree") && key.length == 2 && key[1].equals("height")){
                System.out.println(tree.height());
                continue;
            }

            if(key[0].equals("tree") && key.length == 2 && key[1].equals("external")){
                System.out.println(tree.getExternalValues());
                continue;
            }



            if(key[0].equals("tree") && key.length == 2 && key[1].equals("help")){
                System.out.println("\u001B[36mMenú de ayuda Tree\u001B[0m\n" +
                "\u001B[35mtree push <values>\u001B[0m : agrega el valor en el arbol. El valor a agregar puede ser uno o multiples elementos separados por comas. E.g. tree push 2,25,6,89\n" +
                "\u001B[35mtree remove\u001B[0m : elimina el valor del arbol sin eliminar los hijos de dicho valor eliminado. El arbol se debe volver a ordenar.\n" +
                "\u001B[35mtree greatest\u001B[0m : imprime el mayor valor guardado en el arbol.\n" +
                "\u001B[35mtree smallest\u001B[0m : imprime el menor valor guardado en el arbol.\n" +
                "\u001B[35mtree height\u001B[0m : imprime la altura del arbol.\n" +
                "\u001B[35mtree external\u001B[0m : imprime los nodos externos del arbol.\n" + 
                "\u001B[35mtree\u001B[0m : imprime el contenido del arbol."
                );
                continue;
            }

            if(key[0].equals("tree") && key.length != 1){ 
                System.out.println("\u001B[31mFaltan argumentos, tree help para mas información\u001B[0m"); 
            }

            //* -------------- Graph -------------- *//

            if(key[0].equals("graph") && key.length == 1){ System.out.println(graph); }

            if(key[0].equals("graph") && key.length == 4 && key[1].equals("push") && key[2].equals("vertex")){
                graph.addVertex(key[3]);
                continue;
            }

            if(key[0].equals("graph") && key.length == 6 && key[1].equals("push") && key[2].equals("edge")){
                graph.addEdge(key[3], key[4], Double.parseDouble(key[5]));
                continue;
            }

            if(key[0].equals("graph") && key.length == 2 && key[1].equals("help")){
                System.out.println("\u001B[36mMenú de ayuda Graph\u001B[0m\n" +
                "\u001B[35mgraph push vertex <name>\u001B[0m : agrega un vertice al arbol.\n" +
                "\u001B[35mgraph push edge <from> <to> <weight>\u001B[0m : agrega una arista entre los vertices. Si el vertice origen no existe entonces lo crea. Si el vertice destino no existe entonces lo crea.\n" + 
                "\u001B[35mgraph\u001B[0m : imprime el contenido del grafo."
                );
                continue;
            }

            if(key[0].equals("graph") && key.length != 1){ 
                System.out.println("\u001B[31mFaltan argumentos, graph help para mas información\u001B[0m"); 
            }

            //* -------------- Misc -------------- *// 

            if(key[0].equals("welcome")){ System.out.println(welcomeMSG); }

            if(key[0].equals("version")){ System.out.println("v 0.1 2023-8-16"); }

            if(key[0].equals("author")){ System.out.println("\u001B[33mNombre: Enrique Madrid\nCorreo: meavilam@unah.hn\n# de Cuenta: 20211021353\nPAC: II PAC\nAsignatura: Algoritmos y Estructura de Datos\nDocente: Ing. JOSE MANUEL INESTROZA MURILLO\u001B[0m"); }

            if(key[0].equals("help")){
                System.out.println("\u001B[36mMenú de ayuda general\u001B[0m\n" +
                "\u001B[35mexit\u001B[0m : permite finalizar el programa.\n" +
                "\u001B[35mauthor\u001B[0m : imprime la información del autor del sistema.\n" + 
                "\u001B[35mversion\u001B[0m : imprime la versión y fecha del sistema.\n" +
                "\u001B[35mwelcome\u001B[0m : imprime nuevamente el mensaje de bienvenida.\n" +
                "\u001B[35mhistory\u001B[0m : imprime el contenido del histórico de comandos generados en la consola.\n" + 
                "\u001B[35mlinkedlist help\u001B[0m : imprime la lista de comandos aceptados de linkedlist.\n" +
                "\u001B[35mtree help\u001B[0m : imprime la lista de comandos aceptados de tree.\n" + 
                "\u001B[35mgraph help\u001B[0m : imprime la lista de comandos aceptados de graph."
                );
            }
            
            if(key[0].equals("exit")){ break; }
        }

        sc.close();
    }
}
