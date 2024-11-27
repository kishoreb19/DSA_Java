package dynamicProgramming;

import java.util.Arrays;

public class FibonacciSeries {

    public int fib_rec(int n) {
        //Recursive Fibonacci Series
        if(n==0 || n== 1) return n;
        return fib_rec(n-2) + fib_rec(n-1);
        //Time  Complexity - O(2ⁿ) (Each level doubles the number of calls)
        //Space Complexity - O(n) (Call Stack)
    }

    int fib_dp(int n, int[] dp){
        //Fibonacci Series using DP
        if(n==0||n==1) return n;

        if(dp[n]==-1){
            dp[n] = fib_dp(n-2,dp) + fib_dp(n-1,dp);
        }
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fib_dp(n,dp);
        //Time  Complexity - O(n)
        //Space Complexity - O(n)+O(n) -> O(n) (Call Stack + DP Array)
    }

    public int fib_tabulation(int n) {
        //Fibonacci Series using Tabulation
        if(n==0||n==1) return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;//This will make error when n=1 because, n+1 -> 0+1 = 1, but dp[1] 1 is out of index, that's why we are using base case.

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    public int fib_space_optimized(int n) {
        //Fibonacci Series Space Optimized
        if(n==0||n==1) return n;

        int prev1 = 0;
        int prev2 = 1;
        for(int i=2;i<=n;i++){
            int curr = prev2 + prev1;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/fibonacci-number/description/
    //https://www.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
}