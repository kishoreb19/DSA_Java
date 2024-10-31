package heaps.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestSubArraySum {
    public static int getKthLargest(ArrayList<Integer> arr, int k) {

        // Write your code here
        int n = arr.size();
        PriorityQueue<Integer>pq = new PriorityQueue<>(); // Min Heap
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr.get(j);
                if(pq.size()!=k){
                    pq.add(sum);
                }else{
                    if(sum>pq.peek()){
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }
        return pq.peek();
        //Time Complexity - O((N^2)log(k))
        //Space Complexity - O(k)
        //https://www.naukri.com/code360/problems/k-th-largest-sum-contiguous-subarray_920398?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
