package graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithmBFS {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Write your code here
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj[src].add(dest);
        }
        //Adjacency List prepared

        //Kahn's Algorithm
        int[] inDegree = new int[v];
        ArrayList<Integer>ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //Calculate inDegree of all the nodes
        for(int i = 0; i < v; i++) {
            for(int neighbor : adj[i]) {
                inDegree[neighbor]++;
            }
        }
        //Add nodes to queue whose inDegree is zero
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){//BFS
            int currNode = q.poll();
            ans.add(currNode);
            for(int neighbor : adj[currNode]){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }

        return ans;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/topological-sort_982938?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
