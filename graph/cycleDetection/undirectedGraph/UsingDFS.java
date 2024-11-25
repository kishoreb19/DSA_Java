package graph.cycleDetection.undirectedGraph;

import java.util.ArrayList;

public class UsingDFS {

    static boolean dfs(int node, int parent, boolean[] visited, ArrayList<Integer>[] adj){
        visited[node] = true;
        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                boolean cycleDetected = dfs(neighbor,node,visited,adj);
                if(cycleDetected){
                    return true;
                }
            }else if(visited[neighbor] && neighbor!=parent){
                return true;
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Build the adjacency list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int src = edges[i][0] - 1; // Convert to 0-based indexing
            int dest = edges[i][1] - 1; // Convert to 0-based indexing

            adj[src].add(dest);
            adj[dest].add(src);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i,-1,visited,adj)) {
                    return "Yes";  // Cycle found, no need to check further
                }
            }
        }
        return "No";
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/cycle-detection-in-undirected-graph_1062670?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
