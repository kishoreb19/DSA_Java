package graph.problems;
import java.util.*;

public class MinimumMultiplicationsToReachEnd {

    class Pair{
        int n,steps;
        Pair(int n, int steps){
            this.n = n;
            this.steps = steps;
        }
    }


    //Using Dijkstra Algorithm with Queue
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));

        int[] dist = new int[(int)1e5];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;


        while(!q.isEmpty()){
            Pair p = q.poll();
            int n = p.n;
            int steps = p.steps;

            if(n==end){
                return steps;
            }

            for(int i : arr){
                int neighbor = n*i % (int)1e5;
                if(steps + 1 < dist[neighbor]){
                    dist[neighbor] = steps + 1;
                    q.add(new Pair(neighbor,dist[neighbor]));
                }
            }
        }

        return -1;
        //Time  Complexity - O(k * 10^5)
        //Space Complexity - O(10^5)
    }


//    //Using BFS
//    int minimumMultiplications(int[] arr, int start, int end) {
//
//        // Your code here
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(start,0));
//
//        Set<Integer> visited = new HashSet<>();
//        visited.add(start);
//
//        while(!q.isEmpty()){
//            Pair p = q.poll();
//            int n = p.n;
//            int steps = p.steps;
//
//            if(n == end){
//                return steps;
//            }
//
//            for(int i : arr){
//                int neighbor = (n*i) % 100000;
//                if(!visited.contains(neighbor)){
//                    q.add(new Pair(neighbor,steps+1));
//                    visited.add(neighbor);
//                }
//            }
//        }
//        return -1;
//        //Time  Complexity - O(k * 10^5)
//        //Space Complexity - O(10^5)
//    }
    //https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end
}
