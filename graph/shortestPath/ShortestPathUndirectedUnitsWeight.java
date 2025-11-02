package graph.shortestPath;
import java.util.*;

public class ShortestPathUndirectedUnitsWeight {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int v = adj.size();

        Queue<Integer>q = new LinkedList<>();
        q.add(src);

        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbor : adj.get(node)){
                if(dist[neighbor] == Integer.MAX_VALUE){// OR dist[node] + 1 < dist[neighbor]
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for(int i=0 ;i<v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
        //Time  Complexity - O(V+E)
        //Space Complexity - O(V+E)
    }
    //https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=courseteam_practice_desc&utm_campaign=problem_of_the_day
}