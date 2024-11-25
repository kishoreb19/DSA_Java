package graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalsAlgorithm {
    static void makeSet(int parent[], int rank[], int n){
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int parent[], int node){
        if(parent[node]==node){
            return node;
        }

        int p = findParent(parent, parent[node]);
        parent[node] = p;//Path Compression
        return p;
        //Time Complexity - O(αlpha(n)) -> O(1)
        //Space Complexity - O(logn) (Practically O(1) with path compression)
    }

    static void unionSet(int u, int v, int parent[], int rank[]){
        int p_u = findParent(parent, u);
        int p_v = findParent(parent, v);

        if(rank[p_u]<rank[p_v]){
            parent[p_u] = p_v;
        }else if(rank[p_u]>rank[p_v]){
            parent[p_v] = p_u;
        }else{
            parent[p_v] = p_u;
            rank[p_u]++;
        }
        //Time Complexity - O(1)
    }
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        //Your code goes here
        int[] parent = new int[n];
        int[] rank = new int[n];
        makeSet(parent,rank,n);

        Collections.sort(edges,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer>a, ArrayList<Integer>b){
                return a.get(2)-b.get(2);
            }
        });

        int minWeight=0;
        for(ArrayList<Integer> list : edges){
            int u = list.get(0);  // Node u of the edge
            int v = list.get(1);  // Node v of the edge
            int p_u = findParent(parent, u);
            int p_v = findParent(parent, v);


            if(p_u != p_v){
                unionSet(p_u, p_v, parent, rank);
                minWeight+=list.get(2);
            }
        }
        return minWeight;
    }
    //Time  Complexity - O(VlogV)
    //Space Complexity - O(V)
    //https://www.naukri.com/code360/problems/minimum-spanning-tree_631769?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
}