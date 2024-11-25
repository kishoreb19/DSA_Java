package graph.topologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class UsingDFS {
    static void dfs(int node, boolean visited[], Stack<Integer> st, ArrayList<Integer>[] adj){
        visited[node] = true;
        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                dfs(neighbor,visited,st,adj);
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e)
    {
        // Write your code here
        //Create Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);

            adj[src].add(dest);
        }

        //Topological Sort Code
        Stack<Integer>st = new Stack<>();
        ArrayList<Integer> tSort = new ArrayList<>();
        boolean visited[] = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,st,adj);
            }
        }
        while(!st.isEmpty()){
            tSort.add(st.pop());
        }
        return tSort;
    }
    //Time  Complexity - O(V+E)
    //Space Complexity - O(V+E)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/topological-sort_982938?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
