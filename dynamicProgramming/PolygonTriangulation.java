package dynamicProgramming;

public class PolygonTriangulation {
    int solve_rec(int start, int end, int[] values){
        if(start+1==end){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = start+1; i<=end-1; i++){
            int temp = values[start]*values[i]*values[end] + solve_rec(start,i,values) + solve_rec(i,end,values);
            ans = Math.min(ans,temp);
        }
        return ans;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int start, int end, int[] values, int[][] dp){
        if(start+1==end){
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = start+1; i<=end-1; i++){
            int temp = values[start]*values[i]*values[end] + solve_dp(start,i,values,dp) + solve_dp(i,end,values,dp);
            ans = Math.min(ans,temp);
        }
        return dp[start][end] = ans;
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(int[] values){
        int n = values.length;
        int[][] dp = new int[n][n];

        for(int start=n-1; start>=0; start--){
            for(int end=start+2; end<=n-1; end++){
                int ans = Integer.MAX_VALUE;
                for(int i = start+1; i<=end-1; i++){
                    int temp = values[start]*values[i]*values[end] + dp[start][i] + dp[i][end];
                    ans = Math.min(ans,temp);
                }
                dp[start][end] = ans;
            }
        }
        return dp[0][n-1];
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2)
    }

    //Space Optimization not possible


    public int minScoreTriangulation(int[] values) {
        int n  = values.length;
        // return solve_rec(0,n-1,values);
        // int[][] dp = new int[n][n];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,n-1,values,dp);
        return solve_tab(values);
    }
}
