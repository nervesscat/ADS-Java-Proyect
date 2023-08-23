package Misc;

import java.io.FileWriter;

import Graph.Graph;
import LinkedList.LinkedList;
import Tree.BST;

import java.io.FileReader;
import java.io.BufferedReader;

/**
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-08-21
 */
public class Serializador {

    /**
     * Guarda un string en un archivo
     * @param content String a guardar
     * @param fileName Nombre del archivo
     */
    public static void save(String content, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            fw.write(content);
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Carga un string de un archivo
     * 
     * @param fileName Nombre del archivo
     * @return String con el contenido del archivo
     */
    public static String load(String fileName) {
        String content = "";
        try {
            java.io.BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                content += line + "\n";
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return content;
    }

    public static void treeInsert(BST tree){
        String content = load("Tree.MEAM");
        if (content.length() == 0) {
            return;
        }
        content = content.substring(0, content.length() - 1);
        String[] numbers = content.split(",");
        for(String number : numbers){
            tree.insert(Integer.parseInt(number));
        }
    }

    public static void linkedListInsert(LinkedList<Integer> list){
        String content = load("LinkedList.MEAM");
        content = content.replaceAll("\\s", "");
        
        if(content.contains("null")){
            return;
        }

        String[] numbers = content.split("->");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
    }

    public static void graphInsert(Graph<String> graph){
        String content = load("Graph.MEAM");
        content = content.substring(1, content.length() - 2);
        // * Investigar expresiones regulares
        String[] vertices = content.split("}, " );
        for(String vertex : vertices){
            String auxVert = vertex.split("=")[0];
            if(vertex.split("=[{]").length < 2){
                continue;
            }
            
            vertex = vertex.split("=[{]")[1];
            String[] edges = vertex.replaceAll("[}]", "").split(", ");
            for(String edge : edges){
                String[] vertexInfo = edge.split("=");
                if(vertexInfo.length >= 2){
                    graph.addEdge(auxVert, vertexInfo[0], Double.parseDouble(vertexInfo[1]));
                } else {
                    graph.addVertex(auxVert);
                }
            }
        }
    }
}
