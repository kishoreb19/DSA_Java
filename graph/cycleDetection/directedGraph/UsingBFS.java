package graph.cycleDetection.directedGraph;

import java.util.*;

public class UsingBFS {
    public static boolean detectCycleInDirectedGraph(int v, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        ArrayList<Integer>[] adj = new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.size();i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj[src].add(dest);
        }
        //Adjacency List prepared

        //Kahn's Algorithm
        int[] inDegree = new int[v+1];
        Queue<Integer> q = new LinkedList<>();

        //Calculate inDegree of all the nodes
        for(int i = 1; i <= v; i++) {
            for(int neighbor : adj[i]) {
                inDegree[neighbor]++;
            }
        }
        //Add nodes to queue whose inDegree is zero
        for(int i=1;i<=v;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }

        int count = 0; //Counts number of vertices present in topological sort
        while(!q.isEmpty()){//BFS
            int currNode = q.poll();
            count++;

            for(int neighbor : adj[currNode]){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }
        return !(count==v);
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}