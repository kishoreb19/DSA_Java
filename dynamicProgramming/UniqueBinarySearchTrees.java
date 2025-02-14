package dynamicProgramming;

import java.util.Arrays;

public class UniqueBinarySearchTrees {
    int solve_rec(int n){
        if(n==0 || n==1){
            return 1;
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            ans += solve_rec(i-1) * solve_rec(n-i);
        }
        return ans;
        //Time  Complexity - O(4ⁿ / n^(3/2))
        //Space Complexity - O(n)
    }

    int solve_dp(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            ans += solve_dp(i-1,dp) * solve_dp(n-i,dp);
        }
        return dp[n] = ans;
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n) + O(n)
    }

    int solve_tab(int n){
        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int k=2; k<=n; k++){
            int ans = 0;
            for(int i=1; i<=k; i++){
                ans += dp[i-1] * dp[k-i];
            }
            dp[k] = ans;
        }
        return dp[n];
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n)
    }

    //Space Optimization not possible
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve_dp(n,dp);
    }
    //https://leetcode.com/problems/unique-binary-search-trees/
}
