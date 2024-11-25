package graph.algorithms;

import java.util.*;

public class DijkstraAlgorithm {
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static ArrayList < Integer > dijkstra(ArrayList< ArrayList <Integer>> edges, int v, int e, int source){
        // Write your code here.

        //Prepare Adjacency List
        ArrayList<Pair>[] adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            int src = edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            int weight = edges.get(i).get(2);

            adj[src].add(new Pair(dest,weight));
            adj[dest].add(new Pair(src,weight));
        }
        //prepared

        //Create distance array
        ArrayList<Integer>dist = new ArrayList<>(v);

        for(int i=0;i<v;i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(source, 0);

        //Min-Heap
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();//Poll node with minimum distance
            int currNode = p.node;
            int currWeight = p.weight;

            for(Pair neighbor : adj[currNode]){
                int newWeight = currWeight+neighbor.weight;
                if(newWeight < dist.get(neighbor.node)){
                    dist.set(neighbor.node,newWeight);
                    pq.add(new Pair(neighbor.node,newWeight)); // The priority queue is updated with a new pair for the neighbor node,
                    // which may already exist in the queue, ensuring that the queue holds the shortest known distance for each node.
                }
            }
        }
        return dist;
        //Time  Complexity - O(ElogV)
        //Space Complexity - O(V)
        //Space Complexity - O(V+E) (Considering Adj List preparation)
        //https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}