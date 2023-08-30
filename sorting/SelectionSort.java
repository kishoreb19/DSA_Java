package sorting;

public class SelectionSort {
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){//Change sign for decreasing order
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
//        Worst Case - O(n^2)
//        Best Case -  Ω(n^2)
//        Avg Case -   Θ(n^2)
//        Space Complexity : O(1)
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

        selectionSort(arr);
        System.out.println("After Sorting");
        printArray(arr);
    }
}
