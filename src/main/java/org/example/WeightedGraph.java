package org.example;

package classes;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private boolean undirected;
    private Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    // adds a vertex to the graph
    public void addVertex(Vertex v) {
        map.put(v, new HashMap<>());
    }

    // adds an edge between two vertices with a specified weight
    public void addEdge(Vertex source, Vertex dest, double weight) {
        // Ensure both vertices exist in the graph
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).put(dest, weight);

        if (undirected)
            map.get(dest).put(source, weight);
    }

    private boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).containsKey(dest);
    }

    // Checks if a vertex exists in the graph
    private boolean hasVertex(Vertex source) {
        return map.containsKey(source);
    }

}
