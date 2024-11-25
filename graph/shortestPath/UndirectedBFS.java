package graph.shortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedBFS {
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Write your code here.

        ArrayList<Integer>[] adj = new ArrayList[n+1]; //1 - based indexing
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int src = edges[i][0];
            int dest = edges[i][1];

            adj[src].add(dest);
            adj[dest].add(src);
        }
        //Adjacency List prepared

        int parent[] = new int[n+1];
        boolean visited[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        visited[s] = true;
        parent[s] = -1;
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int neighbor : adj[currNode]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = currNode;
                }
            }
        }

        //Prepare the shortest path
        LinkedList<Integer> ans = new LinkedList<>();
        int currNode = t;
        ans.add(currNode);

        while(currNode != s){
            currNode = parent[currNode];
            ans.add(currNode);
        }
        Collections.reverse(ans);
        return ans;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/shortest-path-in-an-unweighted-graph_981297?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}