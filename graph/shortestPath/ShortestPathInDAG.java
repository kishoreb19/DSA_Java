package graph.shortestPath;

import java.util.*;

public class ShortestPathInDAG {
    class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    void dfs(int node, boolean[] visited, Stack<Integer> st, ArrayList<Pair>[] adj) {
        visited[node] = true;
        for (Pair neighbor : adj[node]) { // Iterate through Pair objects
            if (!visited[neighbor.node]) {
                dfs(neighbor.node, visited, st, adj);
            }
        }
        st.push(node); // Push current node to stack after processing all neighbors
    }

    public int[] shortestPath(int v, int e, int[][] edges) {
        // Create adjacency list
        ArrayList<Pair>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj[src].add(new Pair(dest, weight));
        }
        // Adjacency List Prepared

        // Topological Sort
        boolean visited[] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, st, adj);
            }
        }

        // Finding Shortest Path
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
//        for (int i = 0; i < v; i++) {
//            dist[i] = Integer.MAX_VALUE;
//        }
        int src = 0; // Assuming the source node is 0
        dist[src] = 0;
        while (!st.isEmpty()) {
            int currNode = st.pop();
            if (dist[currNode] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj[currNode]) {
                    if (dist[currNode] + neighbor.weight < dist[neighbor.node]) {
                        dist[neighbor.node] = dist[currNode] + neighbor.weight;
                    }
                }
            } else {
                dist[currNode] = -1;
            }
        }
        return dist;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/0
}
