package dynamicProgramming;

public class MinCostClimbingStairs {

    int solve_rec(int n, int[] cost){
        if(n==1){
            return cost[1];
        }
        if(n==0){
            return cost[0];
        }
        int l = solve_rec(n-1,cost) + cost[n];
        int r = solve_rec(n-2,cost) + cost[n];
        return Math.min(l,r);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int n, int[] cost, int[] dp){
        if(n==1){
            return cost[1];
        }
        if(n==0){
            return cost[0];
        }
        if(dp[n]==-1){
            int l = solve_rec(n-1,cost) + cost[n];
            int r = solve_rec(n-2,cost) + cost[n];
            dp[n] =  Math.min(l,r);
        }
        return dp[n];
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    public int solve_tab(int n, int[] cost) {
        if (n == 0) return cost[0];
        if (n == 1) return cost[1];

        int[] dp = new int[n + 1];

        // Base cases: Starting at step 0 and step 1
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill the dp array for each step from 2 to n
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }

        // Return the minimum cost to reach the top
        return Math.min(dp[n - 1], dp[n - 2]);
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    int solve_space_optimized(int n, int cost[]){
        if (n == 0) return cost[0];
        if (n == 1) return cost[1];


        int prev2 = cost[0];
        int prev1 = cost[1];

        // Fill the dp array for each step from 2 to n
        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev1 + cost[i], prev2 + cost[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        // Return the minimum cost to reach the top
        return Math.min(prev1, prev2);
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }

    public int minCostClimbingStairs(int[] cost) {

        // //solve_rec()
        // int n = cost.length;
        // return Math.min(solve_rec(n-1,cost),solve_rec(n-2,cost));


        // //solve_dp()
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return Math.min(solve_dp(n-1,cost,dp),solve_dp(n-2,cost,dp));

        // //solve_tab()
        // int n = cost.length;
        // return solve_tab(n,cost);

        //solve_space_optimized()
        int n = cost.length;
        return solve_space_optimized(n,cost);
    }
    //https://leetcode.com/problems/min-cost-climbing-stairs/
}
