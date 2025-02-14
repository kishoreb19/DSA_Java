package dynamicProgramming;

public class GuessNumberHigherOrLowerII {
    int solve_rec(int start, int end){
        if(start>=end){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++){
            int x = solve_rec(start,i-1);
            int y = solve_rec(i+1,end);

            ans = Math.min(ans, i + Math.max(x,y));
        }
        return ans;
        //Time  Complexity - O(n!)
        //Space Complexity - O(n)
    }

    int solve_dp(int start, int end, int[][] dp){
        if(start>=end){
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=start; i<=end; i++){
            int x = solve_dp(start,i-1,dp);
            int y = solve_dp(i+1,end,dp);

            ans = Math.min(ans, i + Math.max(x,y));
        }
        return dp[start][end] = ans;
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(int n){
        int[][] dp = new int[n+1][n+1];

        for(int start=n; start>=0; start--){
            for(int end=start+1; end<=n; end++){ // Ensure valid `end > start` because as in rec end is always greater than start
                int ans = Integer.MAX_VALUE;
                for(int i=start; i<=end; i++){
                    int x = solve_dp(start,i-1,dp);
                    int y = solve_dp(i+1,end,dp);

                    ans = Math.min(ans, i + Math.max(x,y));
                }
                dp[start][end] = ans;
            }
        }
        return dp[0][n];
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2)
    }

    //Space Optimization not possible
    public int getMoneyAmount(int n) {

        // int[][] dp = new int[n+1][n+1];
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(1,n,dp);
        return solve_tab(n);
    }
    //https://leetcode.com/problems/guess-number-higher-or-lower-ii/
}
