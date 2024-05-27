package org.example;

package classes;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private boolean undirected;
    private Map<Vertex,Map<Vertex,Double>> map = new HashMap<>();
    public WeightedGraph() {
        this(true);
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.put(v, new HashMap<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return;

        addVertex(source);
        map.get(source).put(dest,weight);
    }

    private boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).containsKey(dest);
    }

    private boolean hasVertex(Vertex source) {
        return map.containsKey(source);
    }

    // to be continued
}