package heaps.problems;

import java.util.PriorityQueue;

public class MinCostOfRopes {
    public long minCost(long[] arr) {
        // code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : arr){
            pq.add(i);
        }

        long cost = 0;
        while(pq.size()>1){
            long a = pq.poll();
            long b = pq.poll();

            long sum = a+b;

            cost+=sum;
            pq.add(sum);
        }
        return cost;
        //Time Complexity - O(nlogn)
        //Space Complexity - O(n)
    }
}
