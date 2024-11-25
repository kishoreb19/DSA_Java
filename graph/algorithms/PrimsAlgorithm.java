package graph.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    //Minimum Spanning Tree
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {

        // Prepare Adjacency List [1-based]
        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);

            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }
        //Adjacency List Prepared

        //Initialize Data Structures
        int[] key = new int[n+1];
        boolean[] mst = new boolean[n+1];
        int[] parent = new int[n+1];

        for(int i=1;i<=n;i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        //Start from source - 1
        key[1] = 0;
        parent[1] = -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.weight-b.weight);

        pq.add(new Pair(1, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currNode = p.node;

            if(!mst[currNode]){
                mst[currNode] = true;

                for(Pair neighbor : adj[currNode]){

                    if(!mst[neighbor.node] && neighbor.weight<key[neighbor.node]){
                        key[neighbor.node] = neighbor.weight;
                        parent[neighbor.node] = currNode;
                        pq.add(new Pair(neighbor.node, neighbor.weight));
                    }
                }
            }
        }

        // Construct the result
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=2;i<=n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(parent[i]);
            temp.add(i);
            temp.add(key[i]);

            ans.add(temp);
        }
        return ans;
    }
    //Time  Complexity - O((V+E)*logV)
    //Space Complexity - O(V)
    //Space Complexity - O(V+E) (Considering Adj List preparation)
    //https://www.naukri.com/code360/problems/prim-s-mst_1095633?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
