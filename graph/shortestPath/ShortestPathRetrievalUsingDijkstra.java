package graph.shortestPath;
import java.util.*;

public class ShortestPathRetrievalUsingDijkstra {

    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public List<Integer> shortestPath(int v, int e, int edges[][]) {
        //  Code Here.
        ArrayList<Pair>[] adj = new ArrayList[v+1];

        for(int i=1; i<=v; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];

            adj[src].add(new Pair(dest,weight));
            adj[dest].add(new Pair(src,weight));
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(1,0));

        int[] parent = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currNode = p.node;
            int currWeight = p.weight;

            for(Pair neighbor : adj[currNode]){
                int neighborNode = neighbor.node;
                int neighborWeight = neighbor.weight;

                int w = currWeight + neighborWeight;

                if(w < dist[neighborNode]){
                    dist[neighborNode] = w;
                    pq.add(new Pair(neighborNode,w));
                    parent[neighborNode] = currNode;
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (dist[v] == Integer.MAX_VALUE){
            return Arrays.asList(-1); // No path found
        }

        int node = v; //Destination Node
        while (node != 1) {
            path.add(0, node);
            node = parent[node];
        }
        path.add(0, 1);// Add the source node

        path.add(0, dist[v]);// Weight of the graph

        return path;
        //Time  Complexity - O(V+E+ElogV)
        //Space Complexity - O(V+E)
    }
    //https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph
}
