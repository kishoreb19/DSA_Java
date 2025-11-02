package graph.problems;

import java.util.Arrays;

public class IsGraphBipartiteDFS {
    boolean dfs(int start, int[][] graph, int[] color, int currColor) {
        color[start] = currColor;

        int newColor = currColor==0?1:0;

        for(int neighbor : graph[start]){
            if(color[neighbor] == currColor){
                return false;
            }
            if(color[neighbor] == -1){
                boolean check = dfs(neighbor,graph,color,newColor);
                if(!check) return false;
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
                if (!dfs(i, graph, color, 0)) {
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
