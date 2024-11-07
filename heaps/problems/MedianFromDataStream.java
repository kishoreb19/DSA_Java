package heaps.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i : arr){
            //Addition
            if(maxHeap.isEmpty() || i<=maxHeap.peek()){
                maxHeap.add(i);
            }else{
                minHeap.add(i);
            }
            //Balancing
            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }
            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            //Finding Median
            if(maxHeap.size() == minHeap.size()){
                list.add((maxHeap.peek()+minHeap.peek())/2);
            }else{
                list.add(maxHeap.peek());
            }
        }
        //Creating answer array
        int ans[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    //Time Complexity - O(nlogn)
    //Space Complexity - O(n)
    //https://www.naukri.com/code360/problems/median-in-a-stream_975268?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    //https://leetcode.com/problems/find-median-from-data-stream/description/
}
