package org.example;


import classes.*;

public class Main {

    public static void main(String[] args) {
        // Creates a directed weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        // Fills the graph with vertices and edges
        fillGraph(weightedGraph);

        // Runs Dijkstra's algorithm
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Astana");


        // Creates another directed weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        // Fills the graph with vertices and edges
        fillGraph(graph);

        // Runs Depth-First Search
        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Astana");



        // Runs Breadth-First Search
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Astana");
    }

    // Method to add vertices and edges to the graph
    public static void fillGraph(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 3.9);
        graph.addEdge("Almaty", "Shymkent", 5.4);
        graph.addEdge("Shymkent", "Astana", 2.1);
        graph.addEdge("Astana", "Kostanay", 7.2);
        graph.addEdge("Shymkent", "Kyzylorda", 3.5);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    // Method to output the path from the start vertex to the key
    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
