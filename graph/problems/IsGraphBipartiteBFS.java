package graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {

    boolean bfs(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // Start coloring with 0

        while (!q.isEmpty()) {
            int node = q.poll();
            int newColor = 1 - color[node]; // Flip color

            for (int neighbor : graph[node]) {
                if (color[neighbor] == color[node]) {
                    return false; // Same color found on both sides
                }
                if (color[neighbor] == -1) { // Unvisited node
                    color[neighbor] = newColor;
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // Uncolored nodes

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // Start BFS for unvisited components
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
        //Time  Complexity - O(V+E)
        //Space Complexity - O(V)
    }
    //https://leetcode.com/problems/is-graph-bipartite/
}
