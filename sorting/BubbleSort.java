package sorting;
public class BubbleSort {
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=1;i<n;i++){
            //For Round 1 to n-1
            boolean swapped = false;
            for(int j=0;j<n-i;j++){
                if(arr[j]>arr[j+1]){//Change sign for decreasing order
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    swapped = true;
                }
            }
            if(swapped==false){
                break;
            }
        }
//        Worst Case - O(n^2)
//        Best Case -  Ω(n)
//        Avg Case -   Θ(n^2)
//        Space Complexity : O(1)
    }
    //Printing Array
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

        bubbleSort(arr);
        System.out.println("After Sorting");
        printArray(arr);
    }
}