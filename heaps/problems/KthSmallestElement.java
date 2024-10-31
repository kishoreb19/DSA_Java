package heaps.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //Max Heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
//    Time Complexity - O(n log k)
//    Space Complexity - O(k)
}
