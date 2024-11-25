package graph.traversal;

import java.util.*;

public class DFS {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,adj,visited,component);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        //Creating Adjacency List for graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Initialize adjacency list for all vertices
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        // Add edges to the adjacency list
        for (int i = 0; i < e; i++) {
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        //Depth First Search starts here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for(int node=0; node<v; node++){
            if(!visited[node]){
                ArrayList<Integer> component = new ArrayList<>();
                dfs(node,adj,visited,component);
                ans.add(component);
            }
        }

        return ans;
    }
    //Time Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //V - > Vertices E -> Edges
}
