package org.example;

package classes;

import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearch<Vertex> extends Search<Vertex>{
    //Constructs the BFS searcher for the given graph starting from the source vertex.
    public BreadthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);

        bfs(graph, source);
    }



     // Performs BFS on the graph from the given starting vertex
    private void bfs(WeightedGraph<Vertex> graph, Vertex current) {
        marked.add(current);


        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex v = queue.remove();

            for (Vertex vertex : graph.getNeighbours(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
