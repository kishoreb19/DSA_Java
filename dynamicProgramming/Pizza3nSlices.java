package dynamicProgramming;

public class Pizza3nSlices {
    int solve_rec(int idx, int endIdx, int n, int[] slices){
        if(n==0 || idx>endIdx){
            return 0;
        }

        int take = slices[idx] + solve_rec(idx+2, endIdx, n-1, slices);
        int notTake = 0 + solve_rec(idx+1,endIdx,n,slices);

        return Math.max(take,notTake);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int idx, int endIdx, int n, int[] slices, int[][] dp){
        if(n==0 || idx>endIdx){
            return 0;
        }

        if(dp[idx][n] != -1) return dp[idx][n];

        int take = slices[idx] + solve_dp(idx+2, endIdx, n-1, slices,dp);
        int notTake = 0 + solve_dp(idx+1,endIdx,n,slices,dp);

        return dp[idx][n] = Math.max(take,notTake);
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(int[] slices){
        int n = slices.length;
        int[][] dp1 = new int[n+2][n+2];
        int[][] dp2 = new int[n+2][n+2];

        for(int idx = n-2; idx>=0; idx--){
            for(int k = 1; k<=n/3; k++){
                int take = slices[idx] + dp1[idx+2][k-1];
                int notTake = 0 + dp1[idx+1][k];

                dp1[idx][k] = Math.max(take,notTake);
            }
        }

        for(int idx = n-1; idx>=1; idx--){
            for(int k = 1; k<=n/3; k++){
                int take = slices[idx] + dp2[idx+2][k-1];
                int notTake = 0 + dp2[idx+1][k];

                dp2[idx][k] = Math.max(take,notTake);
            }
        }

        return Math.max(dp1[0][n/3],dp2[1][n/3]);
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2)
    }

    //Space optimize it on ur own
    int solve_opt(int[] slices){
        int n = slices.length;
        int[] currRow1 = new int[n+2];
        int[] nextRow1 = new int[n+2];
        int[] nextRowx1 = new int[n+2];

        int[] currRow2 = new int[n+2];
        int[] nextRow2 = new int[n+2];
        int[] nextRowx2 = new int[n+2];

        for(int idx = n-2; idx>=0; idx--){
            for(int k = 1; k<=n/3; k++){
                int take = slices[idx] + nextRowx1[k-1];
                int notTake = 0 + nextRow1[k];

                currRow1[k] = Math.max(take,notTake);
            }
            nextRowx1 = nextRow1.clone();
            nextRow1 = currRow1.clone();
        }

        for(int idx = n-1; idx>=1; idx--){
            for(int k = 1; k<=n/3; k++){
                int take = slices[idx] + nextRowx2[k-1];
                int notTake = 0 + nextRow2[k];

                currRow2[k] = Math.max(take,notTake);
            }
            nextRowx2 = nextRow2.clone();
            nextRow2 = currRow2.clone();
        }

        return Math.max(currRow1[n/3],currRow2[n/3]);
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n)
    }
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        // int[][] dp1 = new int[n][n];
        // for(int[] row : dp1){
        //     Arrays.fill(row,-1);
        // }

        // int[][] dp2 = new int[n][n];
        // for(int[] row : dp2){
        //     Arrays.fill(row,-1);
        // }
        // return Math.max(solve_dp(0,n-1-1,n/3,slices,dp1), solve_dp(1,n-1,n/3,slices,dp2));
        return solve_opt(slices);
    }
    //https://leetcode.com/problems/pizza-with-3n-slices/
}
