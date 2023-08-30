package sorting;

public class InsertionSort {
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int t = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = t;
                j--;
            }
        }
//        Worst Case - O(n^2)
//        Best Case -  Ω(n)
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

        insertionSort(arr);
        System.out.println("After Sorting");
        printArray(arr);
    }
}
