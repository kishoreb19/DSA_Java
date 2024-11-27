package graph.algorithms;

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static int[] bellmanFord(int n, int m, int source, List<List<Integer>> edges) {
        // Write your code here.
        if(edges.size() <= 2) return new int[]{-1}; //At least 3 edges (nodes) should be present to test for a cycle
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)1e8);
        dist[source] = 0;

        for(int i=1;i<=n-1;i++){
            for(int j=0;j<m;j++){
                int src = edges.get(j).get(0);
                int dest = edges.get(j).get(1);
                int weight = edges.get(j).get(2);

                if(dist[src]+weight<dist[dest]){
                    dist[dest] = dist[src]+weight;
                }
            }
        }

        //Check for negative weight cycle
        boolean check = false;
        //Run the algorithm one more time
        for(int j=0;j<m;j++){
            int src = edges.get(j).get(0);
            int dest = edges.get(j).get(1);
            int weight = edges.get(j).get(2);

            if(dist[src]+weight<dist[dest]){
                dist[dest] = dist[src]+weight;
                check = true;
                //Optimization
                //You can directly return {-1} from here since update took place so negative weight cycle is present
            }
        }

        return (!check) ? dist:new int[]{-1};
    }
    //Time  Complexity - O(V*E)
    //Space Complexity - O(V);
    //https://www.naukri.com/code360/problems/bellmon-ford_2041977?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}