package org.example;


public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        // adding edges with weights to the graph
        graph.addEdge("Almaty", "Astana", 3.9);
        graph.addEdge("Almaty", "Shymkent", 5.4);
        graph.addEdge("Shymkent", "Astana", 2.1);
        graph.addEdge("Astana", "Kostanay", 7.2);
        graph.addEdge("Shymkent", "Kyzylorda", 3.5);

        // performing Dijkstra's algorithm on the graph
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

        // performing Depth-First Search on the graph
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("\n--------------------------------");

        // performing Breadth-First Search on the graph
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    // printing the path
    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
