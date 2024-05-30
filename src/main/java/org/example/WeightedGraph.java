package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//A class representing a weighted graph
public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();

    //Constructs an undirected weighted graph
    public WeightedGraph() {
        this(true);
    }

    //Constructs a weighted graph
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }


     // Adds a vertex to the graph
    public void addVertex(Vertex v) {
        map.putIfAbsent(v, new HashMap<>());
    }


     //Adds an edge to the graph with the specified weight
    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest)) return;

        map.get(source).put(dest, weight);
        if (undirected) {
            map.get(dest).put(source, weight);
        }
    }


     // Checks if there is an edge between the specified vertices
    public boolean hasEdge(Vertex source, Vertex dest) {
        return hasVertex(source) && map.get(source).containsKey(dest);
    }


     //Checks if the specified vertex exists in the graph
    public boolean hasVertex(Vertex vertex) {
        return map.containsKey(vertex);
    }


     // Gets the neighbors of the specified vertex
    public Set<Vertex> getNeighbours(Vertex vertex) {
        checkVertex(vertex);
        return map.get(vertex).keySet();
    }


     //Gets the weight of the edge between the specified vertices
    public double getEdgeWeight(Vertex source, Vertex dest) {
        if (!hasEdge(source, dest)) {
            throw new IllegalArgumentException("Edge does not exist");
        }
        return map.get(source).get(dest);
    }


     // Prints the graph
    public void printGraph() {
        for (Vertex vertex : map.keySet()) {
            System.out.printf("Vertex %s connected to %s%n", vertex, map.get(vertex));
        }
    }


     // Removes the edge between the specified vertices
    public void removeEdge(Vertex source, Vertex dest) {
        checkVertex(source);
        checkVertex(dest);

        map.get(source).remove(dest);
        if (undirected) {
            map.get(dest).remove(source);
        }
    }


     //Removes the specified vertex and all its edges from the graph
    public void removeVertex(Vertex vertex) {
        checkVertex(vertex);

        for (Vertex neighbor : map.keySet()) {
            map.get(neighbor).remove(vertex);
        }
        map.remove(vertex);
    }


     // Checks if the specified vertex exists in the graph
    private void checkVertex(Vertex vertex) {
        if (!hasVertex(vertex)) {
            throw new IndexOutOfBoundsException("Vertex does not exist");
        }
    }
}
