package greedyAlgorithms;

import java.util.*;
public class MinimumCostOfRopes {

    public int minCost(int[] arr) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i : arr){
            pq.add(i);
        }

        int cost = 0;

        while(pq.size() > 1){
            int a = pq.poll(), b = pq.poll();
            int mergedLength = a+b;
            pq.add(mergedLength);

            cost += mergedLength;
        }
        return cost;
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }
}
