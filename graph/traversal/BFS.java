package graph.traversal;

import java.util.*;

public class BFS {
    static void bfs(int node, boolean visited[], ArrayList<Integer>ans,List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int currNode = q.poll();
            ans.add(currNode);

            for(int neighbor : adj.get(currNode)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int node=0;node<n;node++){//For disconnected graph
            //Checks for Components of graph
            if(!visited[node]){
                bfs(node,visited,ans,adj);
            }
        }
        return ans;

    }
    //Time Complexity - O(V+E)
    //Space Complexity - O(V)
    //V - > Vertices E -> Edges
    //Works for both connected and disconnected graph

    //https://www.naukri.com/code360/problems/bfs-in-graph_973002?leftPanelTabValue=PROBLEM
}
