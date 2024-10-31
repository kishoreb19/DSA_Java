package algorithms;

public class KadanesAlgo {

    //Kadane's Algorithm is used to find the maximum sum
    // of a contiguous subarray within a one-dimensional array of numbers.
    static int kadanes(int arr[]){
        int n=arr.length;
        int sum=0,max=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max = Math.max(sum,max);
            if(sum<0) sum=0;
        }
        return max;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    public static void main(String[] args) {
        System.out.println(kadanes(new int[]{1, -2, 3, 4, -1, 2, 1, -5, 4}));
    }
}
