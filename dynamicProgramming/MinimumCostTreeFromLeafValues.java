package dynamicProgramming;

public class MinimumCostTreeFromLeafValues {

    void precomputeMax(int[] arr, int[][] maxValues) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxValues[i][i] = arr[i]; // Single element
            for (int j = i + 1; j < n; j++) {
                maxValues[i][j] = Math.max(maxValues[i][j - 1], arr[j]);
            }
        }
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2)
    }

    int solve_rec(int start, int end, int[] arr, int[][] maxValues){
        if(start>=end){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = start; i<end; i++){
            int temp = maxValues[start][i] * maxValues[i+1][end]
                    + solve_rec(start,i,arr,maxValues) + solve_rec(i+1,end,arr,maxValues);
            ans = Math.min(ans,temp);
        }
        return ans;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int start, int end, int[] arr, int[][] dp, int[][] maxValues){
        if(start>=end){
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = start; i<end; i++){
            int temp = maxValues[start][i] * maxValues[i+1][end]
                    + solve_dp(start,i,arr,dp,maxValues) + solve_dp(i+1,end,arr,dp,maxValues);
            ans = Math.min(ans,temp);
        }
        return dp[start][end] = ans;
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(int[] arr, int[][] maxValues){
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int start = n - 1; start >= 0; start--){
            for(int end = start + 1; end < n; end++){ // Ensure valid `end > start` because as in rec end is always greater than start
                int ans = Integer.MAX_VALUE;
                for(int i = start; i < end; i++){
                    int temp = maxValues[start][i] * maxValues[i + 1][end]
                            + dp[start][i] + dp[i + 1][end];
                    ans = Math.min(ans, temp);
                }
                dp[start][end] = ans;
            }
        }
        return dp[0][n-1];
        //Time  Complexity - O(n^3)
        //Space Complexity - O(n^2)
    }
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;

        //Calculating max values for all the elements
        int[][] maxValues = new int[n][n]; // Precompute max values
        precomputeMax(arr, maxValues);

        // return solve_rec(0,n-1,arr,maxValues);
        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,n-1,arr,dp,maxValues);
        return solve_tab(arr,maxValues);
    }
    //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
}