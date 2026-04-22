package feature_three;


public class Main {
    public static void main(String[] args) {
        Graph_list g = new Graph_list(5); 

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);

        g.printGraph();

        System.out.println("\n--- Shortest path from 0 to 4 ---");
        g.dijkstra(0, 3);
    }
}
