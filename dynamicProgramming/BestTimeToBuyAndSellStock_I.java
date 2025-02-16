package dynamicProgramming;

public class BestTimeToBuyAndSellStock_I {

    public int maxProfit(int[] arr) {
        int n=arr.length;
        int max = 0;
        int min = arr[0];
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]-min);
        }
        return max;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
}
