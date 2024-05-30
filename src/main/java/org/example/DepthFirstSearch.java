package org.example;

package classes;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    //Constructs the DFS searcher for the given graph starting from the source vertex

    public DepthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);

        dfs(graph, source);
    }

    //Performs DFS on the graph from the given starting vertex
    private void dfs(WeightedGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex v : graph.getNeighbours(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
