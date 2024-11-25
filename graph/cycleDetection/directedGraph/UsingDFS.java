package graph.cycleDetection.directedGraph;

import java.util.ArrayList;

public class UsingDFS {
    static boolean dfs(int node, boolean visited[], boolean dfsVisited[], ArrayList<Integer>[] adj){
        visited[node] = true;
        dfsVisited[node] = true;

        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                if(dfs(neighbor, visited, dfsVisited, adj)){
                    return true;
                }
            }else if(visited[neighbor] && dfsVisited[neighbor]){
                return true;
            }
        }
        //Backtrack
        dfsVisited[node] = false;

        return false;
    }
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        //Create 1-based Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.size();i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj[src].add(dest);
        }
        //Check for cycle in directed graph using DFS
        boolean visited[] = new boolean[n+1];
        boolean dfsVisited[] = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                if(dfs(i,visited,dfsVisited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}