package sorting;

public class QuickSort {
    public static void swap(int arr[],int x,int y){
        int t= arr[x];
        arr[x] = arr[y];
        arr[y]=t;
    }
    public static int partition(int arr[],int start,int end){
        int c=0;
        int pivot = arr[start];
        for(int i=start+1;i<=end;i++){
            if(arr[i]<pivot){
                c++;
            }
        }
        int pivotIndex = start+c;
        swap(arr,start,pivotIndex);

        int i = start; int j = end;
        while(i<pivotIndex && j>pivotIndex){
            while(arr[i]<=arr[pivotIndex]){
                i++;
            }
            while(arr[j]>arr[pivotIndex]){
                j--;
            }
            if(i<pivotIndex && j>pivotIndex){
                swap(arr,i,j);
            }
        }

        return pivotIndex;
    }
    public static void quickSort(int arr[],int l,int r){
        if(l>=r){
            return;
        }
        int pi = partition(arr,l,r);
        quickSort(arr,l,pi-1);
        quickSort(arr,pi+1,r);
//        Worst Case - O(n^2)
//        Best Case -  Ω(nlogn)
//        Avg Case -   Θ(nlogn)
//        Space Complexity : O(logn)
    }

    public static void printArray(int arr[]){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {10,1,7,6,14,9};
        System.out.println("Before Sorting");
        printArray(arr);

        quickSort(arr,0,arr.length-1);
        System.out.println("After Sorting");
        printArray(arr);
    }
}
