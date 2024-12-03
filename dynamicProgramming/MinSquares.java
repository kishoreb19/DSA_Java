package dynamicProgramming;

import java.util.Arrays;

public class MinSquares {
    int solve_rec(int n){

        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){

            int ans = solve_rec(n-(i*i));
            if(ans!=Integer.MAX_VALUE){
                min = Math.min(min,ans+1);
            }

        }
        return min;
        //Time  Complexity - O(root(n)^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int n, int dp[]){
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){

            int ans = solve_dp(n-(i*i),dp);
            if(ans!=Integer.MAX_VALUE){
                min = Math.min(min,ans+1);
            }

        }
        return dp[n] = min;
        //Time  Complexity - O(n*root(n))
        //Space Complexity - O(n) + O(n)
    }

    int solve_tab(int n){
        if(n<0) return Integer.MAX_VALUE;
        if(n==0) return 0;

        int dp[] = new int[n+1];
        dp[0] = 0;

        for(int j=1;j<=n;j++){

            int min = Integer.MAX_VALUE;
            for(int i=1; i*i<=j; i++){ //instead of 'j' you can also write n
                int ans = j-(i*i)>=0 ? dp[j-(i*i)] : Integer.MAX_VALUE;
                if(ans!=Integer.MAX_VALUE){
                    min = Math.min(min,ans+1);
                }
            }
            dp[j] = min;

        }
        return dp[n]!=Integer.MAX_VALUE ? dp[n]:-1;
        //Time  Complexity - O(n*root(n))
        //Space Complexity - O(n)
    }


    public int minSquares(int n) {
        // Code here

        /* Constraints:
           1 <= n <= 1e4
        */

        //solve_rec();
        // int ans = solve_rec(n);
        // return ans!=Integer.MAX_VALUE?ans:-1;

        // //solve_dp()
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans = solve_dp(n,dp);
        // return ans!=Integer.MAX_VALUE?ans:-1;

        //solve_tab()
        return solve_tab(n);
    }
    //https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1
}
