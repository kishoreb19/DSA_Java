package graph.algorithms;

import java.util.*;

public class TarjansAlgorithm_ArticulationPoints {

    void dfs(int node,boolean visited[],int parent[],int disc[],int low[],
             ArrayList<ArrayList<Integer>> adj,HashSet<Integer>articulationPoints,int[] timer){

        visited[node] = true;
        disc[node] = timer[0];
        low[node] = disc[node];

        int child = 0;//Counts unvisited children

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                child++;
                timer[0]++;
                parent[neighbor] = node;

                dfs(neighbor,visited,parent,disc,low,adj,articulationPoints,timer);

                low[node] = Math.min(low[node],low[neighbor]);

                //Articulation point check
                if(low[neighbor] >= disc[node] && parent[node]!=-1){
                    articulationPoints.add(node);
                }

            }else if(visited[neighbor] && parent[node] != neighbor){
                //Back edge Case
                low[node] = Math.min(low[node],disc[neighbor]);
            }
        }

        //Special case where node is a starting node
        if(parent[node]==-1 && child>1){
            articulationPoints.add(node);
        }
    }
    public ArrayList<Integer> articulationPoints(int v,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] disc = new int[v];
        int[] low = new int[v];
        int[] parent = new int[v];
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            disc[i] = -1;
            low[i] = -1;
            parent[i] = -1;
            visited[i] = false;
        }

        int[] timer = {0};

        HashSet<Integer>articulationPoints = new HashSet<>();
        //We are using hashset because there can be a chance that
        //the same node is identified as an articulation point for multiple neighbors.

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,parent,disc,low,adj,articulationPoints,timer);
            }
        }
        //Add the articulation points to result
        ArrayList<Integer> result = new ArrayList<>(articulationPoints);
        Collections.sort(result);
        // Check if no articulation points exist
        if (result.isEmpty()) {
            result.add(-1); // Add -1 if no articulation points
        }
        return result;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //https://www.geeksforgeeks.org/problems/articulation-point-1/1
}