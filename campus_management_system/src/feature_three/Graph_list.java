package feature_three;

import java.util.*;

public class Graph_list {
    private LinkedList<Node>[] adjacencyList;
    private int numVertices;

    public Graph_list(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new Node(destination, weight));
        adjacencyList[destination].add(new Node(source, weight)); 
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " → ");
            for (Node node : adjacencyList[i]) {
                System.out.print("[To: " + node.destination + ", W: " + node.weight + "] ");
            }
            System.out.println();
        }
    }

    public void dijkstra(int source, int target) {
        int[] distance = new int[numVertices];
        int[] previous = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distance, Integer.MAX_VALUE); // Unlimited 
        Arrays.fill(previous, -1); // NO previous yet 
        distance[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.destination;

            if (visited[u]) continue;
            visited[u] = true;

            for (Node neighbor : adjacencyList[u]) {
                int v = neighbor.destination;
                int weight = neighbor.weight;

                if (!visited[v] && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        if (distance[target] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + source + " to " + target);
            return;
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (int at = target; at != -1; at = previous[at]) {
            path.addFirst(at);
        }

        System.out.print("Shortest path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" → ");
        }
        System.out.println("\nTotal cost: " + distance[target]);
    }
}
