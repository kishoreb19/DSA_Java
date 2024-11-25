package graph.algorithms;

import java.util.*;

public class KosarajusAlgorithm {


    //Used for finding strongly connected components in a directed graph.


    static void dfs(int node,boolean[] visited,Stack<Integer>st,ArrayList<Integer>[] adj){
        visited[node] = true;
        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                dfs(neighbor,visited,st,adj);
            }
        }
        st.add(node);
    }

    static void revDfs(int node,boolean[] visited,ArrayList<Integer>[] transpose){
        visited[node] = true;
        for(int neighbor : transpose[node]){
            if(!visited[neighbor]){
                revDfs(neighbor,visited,transpose);
            }
        }
    }
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<Integer>[] adj = new ArrayList[v];
        ArrayList<Integer>[] transpose = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
            transpose[i] = new ArrayList<>();
        }

        for(int i=0;i<edges.size();i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj[src].add(dest);

            transpose[dest].add(src); //Creates a adj list where the edges are reversed
        }

        //Topological Sort
        Stack<Integer>st = new Stack<>();
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,st,adj);
            }
        }

        int components = 0;
        //Mark all the nodes unvisited
        Arrays.fill(visited,false);

        //Call DFS for each topological elements
        while(!st.isEmpty()){
            int currNode = st.pop();
            if(!visited[currNode]){
                components++;
                revDfs(currNode,visited,transpose);
            }
        }
        return components;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //https://www.naukri.com/code360/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
