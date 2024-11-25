package graph.cycleDetection.undirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UsingBFS {
    static boolean bfs(int node, boolean visited[], ArrayList<Integer>[] adj){
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();

        visited[node] = true;
        parent[node] = -1;
        q.offer(node);

        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int neighbor : adj[currNode]){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = currNode;
                }else if(visited[neighbor] && parent[currNode] != neighbor){
                    return true;
                    //If a neighbor is already visited, then it should be the parent of current node
                    //or else if it's not, then cycle exists
                }
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

        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {//Check which component of undirected graph contains cycle
                if (bfs(i,visited,adj)) {
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
