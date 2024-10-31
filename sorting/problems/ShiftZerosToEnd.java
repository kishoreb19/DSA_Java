package sorting.problems;

public class ShiftZerosToEnd {
    public static void shiftZerosToEnd(int arr[]){
        int n = arr.length;
        int nonZeroIndex = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                nonZeroIndex++;  // Increment nonZeroIndex after swapping
            }
        }
        // Time Complexity - O(N)
    }

//    public static void shiftZerosToEnd(int arr[]){
//        //bubble sort
//        for(int i=1;i<arr.length;i++){
//            for(int j=0;j< arr.length-i;j++){
//                if(arr[j]==0 && arr[j+1] !=0){
//                    int t = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = t;
//                }
//            }
//        }
//        //Time Complexity - O(N^2)
//    }

    public static void main(String[] args) {
        int arr[] = {0,0,3,2,1,0};
        shiftZerosToEnd(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
