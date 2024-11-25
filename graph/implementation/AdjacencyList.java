package graph.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdjacencyList {
    static class Graph{
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        //Adding edge to graph
        void addEdge(int u, int v, boolean direction){
            //u -> source  v -> destination
            //direction = false -> undirected
            //direction = true ->  directed
            adj.putIfAbsent(u,new ArrayList<>());
            adj.get(u).add(v);
            if(!direction){
                adj.putIfAbsent(v,new ArrayList<>());
                adj.get(v).add(u);
            }
        }

        void printAdjList(){
            for(int i : adj.keySet()){
                System.out.print(i+" -> ");
                for(int j : adj.get(i)){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();
        int n,m;
        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        m = sc.nextInt();
        System.out.println();
        for(int i=0;i<m;i++){
            g.addEdge(sc.nextInt(),sc.nextInt(),false);
        }
        g.printAdjList();

    }
}
