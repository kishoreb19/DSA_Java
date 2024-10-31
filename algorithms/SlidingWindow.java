package algorithms;

public class SlidingWindow {
    static void slidingWindowBruteForce(int arr[],int k){
        int n=arr.length;
        for(int i=0;i<=n-k;i++){
            int max=0;
            for(int j=0;j<k;j++){
                if(arr[i+j]>max){
                    max = arr[i+j];
                }
            }
            System.out.print(max+" ");
        }
        //Time Complexity - O(N*K)
        //Space Complexity - O(1)
    }

    static void SlidingWindowOptimized(int arr[], int k){
        int n=arr.length;
        if (n == 0 || k == 0 || k > n) return;

        int windowSum=0,maxSum=0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        maxSum = Math.max(maxSum,windowSum);
        for(int i=k;i<n;i++){
            System.out.println(maxSum);
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    public static void main(String[] args) {

    }
}
