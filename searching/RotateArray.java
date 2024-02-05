package searching;

public class RotateArray {
    public void reverse(int[] arr, int start, int end ){
        while(start<end){
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }

    public void rotate_Right(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Adjust k to be within the range of array length

        reverse(arr, 0, n - 1); // Reverse the entire array O(N)
        reverse(arr, 0, k - 1); // Reverse the first k elements O(k)
        reverse(arr, k, n - 1); // Reverse the remaining n-k elements O(n-k)
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    public void rotate_Left(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Adjust k to be within the range of array length

        reverse(arr, 0, n - 1); // Reverse the entire array O(N)
        reverse(arr, 0, n-k-1); // Reverse the first k elements O(n-k)
        reverse(arr, n-k, n - 1); // Reverse the remaining k elements O(k)
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    //--------------------------------------------------------------------------------------------
    //(Alternative) Time Complexity - O(N*k) Space Complexity - O(1)
    public static int[] rotateArrayByKLEFT(int arr[],int k){
        int n = arr.length;
        k=k%n;
        //In certain cases, k might be greater than the length of the array.
        //For example, if the array length is 5 and k is 7, rotating by 7 positions is the
        //same as rotating by 2 positions in a circular manner (because 7 % 5 = 2).
        for(int i =1;i<=k;i++){
            int x = arr[0];
            for(int j=0;j<n-1;j++){
                //Shift elements to left
                arr[j] = arr[j+1];
            }
            arr[n-1] = x;
        }
        return arr;
        //Input  - 1 2 3 4 K=1
        //Output - 2 3 4 1
    }
    public static int[] rotateArrayByKRIGHT(int arr[],int k){
        int n = arr.length;
        k=k%n;
        for(int i =1;i<=k;i++){
            int x = arr[n-1];
            for(int j=n-1;j>0;j--){
                //Shift elements to right
                arr[j] = arr[j-1];
            }
            arr[0] = x;
        }
        return arr;
        //Input  - 1 2 4 3 5 6  K=2
        //Output - 5 6 1 2 4 3
    }
}
