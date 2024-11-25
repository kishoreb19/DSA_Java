package graph.algorithms;

import java.util.*;

public class TarjansAlgorithm_BridgeDetection {

    //Tarjan's Algorithm
    static void dfs(int node, boolean[] visited, int[] parent, int[] disc, int[] low, int[] timer, List<List<Integer>>result, ArrayList<Integer>[] adj){
        visited[node] = true;//Mark visited
        disc[node] = timer[0];
        low[node] = timer[0];

        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                timer[0]++;//Increment timer
                parent[neighbor] = node;//Mark parent

                dfs(neighbor, visited, parent, disc, low, timer, result, adj);
                //In case neighbor (child) has made any back edge with any other node
                low[node] = Math.min(low[node],low[neighbor]);

                //Check if bridge is present
                if(low[neighbor] > disc[node]){
                    List<Integer>ans = new ArrayList<>();
                    ans.add(node);
                    ans.add(neighbor);
                    result.add(ans);//Add bridge to result
                }
            }else if(visited[neighbor] && parent[node]!=neighbor){
                low[node] = Math.min(low[node],disc[neighbor]);
            }
        }
    }
    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {

        // Write your code here!

        //Prepare Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int src = edges[i][0];
            int dest = edges[i][1];

            adj[src].add(dest);
            adj[dest].add(src);
        }
        //prepared

        int[] disc = new int[v];//Discovery time
        int[] low = new int[v];//Earliest possible time
        int[] parent = new int[v];
        boolean[] visited = new boolean[v];

        //Initialise the data structures
        Arrays.fill(disc,-1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);

        int[] timer = {0};//Pass by reference
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<v;i++){//DFS Call
            if(!visited[i]){
                dfs(i,visited,parent,disc,low,timer,result,adj);
            }
        }
        return result;
        //Time  Complexity - O(V+E)
        //Space Complexity - O(V)
        //Space Complexity - O(V+E) (Considering Adj List preparation)
        //https://www.naukri.com/code360/problems/bridges-in-graph_893026?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
