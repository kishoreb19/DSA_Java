package graph.algorithms;
import java.util.*;

public class DijkstraUsingSet {
    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        // For TreeSet to compare based on weight
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {

        ArrayList<Pair>[] adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
        }

        // Creating adjacency list
        for (int i = 0; i < edges; i++) {
            int src = vec.get(i).get(0);
            int dest = vec.get(i).get(1);
            int weight = vec.get(i).get(2);

            adj[src].add(new Pair(dest, weight));
            adj[dest].add(new Pair(src, weight)); // For undirected graph
        }

        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(vertices, Integer.MAX_VALUE));
        dist.set(source, 0);

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.weight == b.weight)
                return a.node - b.node;  // To avoid duplicate weights issue
            return a.weight - b.weight;
        });

        set.add(new Pair(source, 0));

        while (!set.isEmpty()) {
            Pair p = set.pollFirst();  // Get & remove the smallest weight node
            int node = p.node;

            for (Pair neighbor : adj[node]) {
                int neighborNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (dist.get(node) + edgeWeight < dist.get(neighborNode)) {
                    // Remove old Pair if exists
                    //Optional but makes the algorithm faster
                    set.remove(new Pair(neighborNode, dist.get(neighborNode)));

                    dist.set(neighborNode, dist.get(node) + edgeWeight);
                    set.add(new Pair(neighborNode, dist.get(neighborNode)));
                }
            }
        }

        return dist;
    }
    ////https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
