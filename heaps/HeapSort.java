package heaps;

import java.util.Arrays;

public class HeapSort {
    static void swap(int arr[], int x, int y){
        arr[x] = arr[x]^arr[y];
        arr[y] = arr[x]^arr[y];
        arr[x] = arr[x]^arr[y];
    }
    static void heapify(int arr[],int size, int i){
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left<=size && arr[largest]<arr[left]){
            largest = left;
        }
        if(right<=size && arr[largest]<arr[right]){
            largest = right;
        }
        if(largest!=i){
            swap(arr,i,largest);
            heapify(arr,size,largest);
        }
    }
    static void buildHeap(int arr[]){
        int n = arr.length-1;
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }
    }
    static void heapSort(int arr[]){
        int size = arr.length-1;//Last node
        while(size>1){
            swap(arr,1,size);
            size--;
            heapify(arr,size,1);
        }
        //Time Complexity - O(NlogN)
    }

    static void print(int arr[]){
        for(int i =1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {-1,54,53,55,52,50};
        print(arr);
        //First Build the heap then perform heap sort
        System.out.println("Build Heap: ");
        buildHeap(arr);
        print(arr);
        //Perform heap sort
        System.out.println("Heap Sort: ");
        heapSort(arr);
        print(arr);
    }
}
