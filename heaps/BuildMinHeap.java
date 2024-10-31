package heaps;

import java.util.Collections;

public class BuildMinHeap {
    static void heapify(int arr[], int size, int i){
        int smallest = i;
        int left = 2*i+1;
        int right = left+1;
        if(left<size && arr[left]<arr[smallest]){
            smallest = left;
        }
        if(right<size && arr[right]<arr[smallest]){
            smallest = right;
        }
        if(smallest!=i){
            arr[smallest] = arr[smallest] ^ arr[i];
            arr[i] = arr[smallest] ^ arr[i];
            arr[smallest] = arr[smallest] ^ arr[i];
            heapify(arr, size, smallest);
        }
    }
    public static int[] buildMinHeap(int[] arr)
    {
        // Write your code here
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr, n, i);
        }
        return arr;
    }
    //https://www.naukri.com/code360/problems/build-min-heap_1171167?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
