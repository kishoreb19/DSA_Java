package dynamicProgramming;

public class WaysToReachTheNthStairs {

    static final int MOD = 1000000007;

    static int solve_rec(int i, int n){
        if(i>n) return 0;
        if(i==n){
            return 1;
        }
        //Explore all ways
        int l = solve_rec(i+1,n);
        int r = solve_rec(i+2,n);

        return l+r;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)

    }
    static int solve_dp(int i, int n, int[] dp){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(dp[i]==-1){
            dp[i] = (solve_dp(i+1,n,dp)+solve_dp(i+2, n, dp))%MOD;
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    static int solve_tab(int i, int n){
        if (n == 0) return 1; // No steps to climb means 1 way (stay at ground).
        if (n == 1) return 1;

        int dp[] = new int[n+1];
        dp[n]=1;
        dp[n-1] = 1;
        for(int j=n-2;j>=0;j--){
            dp[j] = (dp[j+1] + dp[j+2])%MOD;
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    static int solve_space_opt(int i, int n){
        if (n == 0) return 1; // No steps to climb means 1 way (stay at ground).
        if (n == 1) return 1;

        int p1 = 1;
        int p2 = 1;
        for(int j=n-2;j>=0;j--){
            int curr = (p1+p2)%MOD;
            p2 = p1;
            p1 = curr;
        }
        return p1;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
    public static long countDistinctWayToClimbStair(int n) {
        // Write your code here.

        // //solve_rec
        // return solve_rec(0,n);


        // //solve_dp
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return solve_dp(0,n,dp);

        // //solve_tab
        // return solve_tab(0, n);

        //Space Optimized
        return solve_space_opt(0, n);
    }
    //https://www.naukri.com/code360/problems/count-ways-to-reach-nth-stairs_798650?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
}
