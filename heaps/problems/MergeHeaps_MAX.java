package heaps.problems;

import java.util.ArrayList;

public class MergeHeaps_MAX {
    void heapify(int arr[], int size, int i){ // For 0 - based Indexing
        int largest = i;
        while(i<size){
            int left = 2*i + 1;
            int right = left + 1;

            if(left<size && arr[largest]<arr[left]){
                largest = left;
            }
            if(right<size && arr[largest]<arr[right]){
                largest = right;
            }

            if(largest!=i){
                int t = arr[largest];
                arr[largest] = arr[i];
                arr[i] = t;

                i = largest;
            }else{
                return;
            }
        }
        //Time Complexity - O(logN)
        //Space Complexity - O(1)
    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : a){
            list.add(i);
        }
        for(int i : b){
            list.add(i);
        }

        int arr[] = new int[list.size()];

        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }

        int size = arr.length;
        for(int i=(size/2)-1;i>=0;i--){ //For 0 - based indexing
            heapify(arr,size,i);
        }
        return arr;
        //Time Complexity - O((a+b)log(a+b)) i.e O((size)log(size)
        //Space Complexity - O(a+b)
        //https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
    }
}
