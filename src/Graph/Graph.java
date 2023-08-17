package Graph;

import Map.JSON;

/**
 * Estructura de datos de tipo graph creada enteramente usando JSON.
 * 
 * @author meavilam@unah.hn
 * @version 1.0
 * @since 2023-07-28
 * @see Edge
 * @see Vertex
 * @see JSON
 */

public class Graph<T> {
    
    private JSON<Vertex<T>, Edge<T>> graph;

    public Graph() {
        this.graph = new JSON<Vertex<T>, Edge<T>>();
    }

    /**
     * Inserta un nuevo vertice con un valor dado
     * 
     * @param name Valor a insertar
     */

    public void addVertex(T name) {
        this.graph.add(new Vertex(name), new Edge());
    }

    private void addVertex(Vertex<T> vertex) {
        this.graph.add(vertex, new Edge());
    }

    /**
     * Agrega una arista entre dos vertices
     * 
     * @param from Source o Arista inicial
     * @param to Endpoint o arista final
     * @param value Weight o peso de la arista
     */

    public void addEdge(T from, T to, double value) {
        // Search for the vertex with the name "from"
        Vertex<T> fromVertex = null;
        for (Vertex<T> vertex : this.graph.getKeys()) {
            if (vertex.getName().equals(from)) {
                fromVertex = vertex;
                break;
            }
        }

        // Search for the vertex with the name "to"
        Vertex<T> toVertex = null;
        for (Vertex<T> vertex : this.graph.getKeys()) {
            if (vertex.getName().equals(to)) {
                toVertex = vertex;
                break;
            }
        }

        // If the vertex with the name "from" does not exist, create it
        if (fromVertex == null) {
            fromVertex = new Vertex(from);
            this.addVertex(fromVertex);
        }

        // If the vertex with the name "to" does not exist, create it
        if (toVertex == null) {
            toVertex = new Vertex(to);
            this.addVertex(toVertex);
        }

        // Add the edge
        this.graph.get(fromVertex).add(toVertex, value);
        // ! this.graph.get(toVertex).add(fromVertex, value); Uncomment this line if you want to make the graph undirected
    }

    /**
     * Agrega una arista entre dos vertices (peso con valor 1)
     * 
     * @param from Arista inicial
     * @param to Endpoint o arista final
     */
    public void addEdge(T from, T to){
        this.addEdge(from, to, 1);
    }

    @Override
    public String toString() {
        return this.graph.toString();
    }
}
