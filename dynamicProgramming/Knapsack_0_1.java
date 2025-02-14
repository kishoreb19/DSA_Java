package dynamicProgramming;

public class Knapsack_0_1 {

    static int solve_rec(int i, int W, int[] wt, int[] val){
        int n = wt.length;
        if(i==n || W==0){
            return 0;
        }

        if(wt[i]>W){
            return 0 + solve_rec(i+1,W,wt,val);
        }
        int include = val[i] + solve_rec(i+1,W-wt[i],wt,val);
        int exclude = 0 + solve_rec(i+1,W,wt,val);;

        return Math.max(include,exclude);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int i, int W, int[] wt, int[] val, int[][] dp){
        int n = wt.length;

        if(i==n || W==0) return 0;

        if(dp[i][W] != -1){
            return dp[i][W];
        }

        if(wt[i]>W){
            return 0 + solve_dp(i+1,W,wt,val,dp);
        }
        int include = val[i] + solve_dp(i+1,W-wt[i],wt,val,dp);
        int exclude = 0 + solve_dp(i+1,W,wt,val,dp);

        return dp[i][W] = Math.max(include,exclude);
        //Time  Complexity - O(nW)
        //Space Complexity - O(nW)+O(n)
    }

    static int solve_tab(int W, int[] wt, int[] val){
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=W;i++){
            dp[n][i] = 0;
        }

        for(int i=n-1;i>=0;i--){
            for(int j =1; j<=W;j++){
                if(wt[i]>j){
                    dp[i][j] = 0 + dp[i+1][j];
                }else{

                    int include = val[i] + dp[i+1][j-wt[i]];
                    int exclude = 0 + dp[i+1][j];

                    dp[i][j] = Math.max(include,exclude);

                }
            }
        }
        return dp[0][W];
        //Time  Complexity - O(nW)
        //Space Complexity - O(nW)
    }

    static int solve_opt(int W, int[] wt, int[] val){
        int n = wt.length;
        int[] currRow = new int[W+1];
        int[] nextRow = new int[W+1];

        for(int i=n-1;i>=0;i--){
            for(int j =1; j<=W;j++){
                if(wt[i]>j){
                    currRow[j] = 0 + nextRow[j];
                }else{
                    int include = val[i] + nextRow[j-wt[i]];
                    int exclude = 0 + nextRow[j];
                    currRow[j] = Math.max(include,exclude);
                }
            }
            nextRow = currRow.clone();
        }
        return currRow[W];
        //Time  Complexity - O(nW)
        //Space Complexity - O(2W) - O(W)
    }

    static int solve_more_opt(int W, int[] wt, int[] val){
        int n = wt.length;
        int[] currRow = new int[W+1];

        for(int i=n-1;i>=0;i--){
            for(int j =W; j>=1;j--){
                if(wt[i]>j){
                    currRow[j] = 0 + currRow[j];
                }else{
                    int include = val[i] + currRow[j-wt[i]];
                    int exclude = 0 + currRow[j];
                    currRow[j] = Math.max(include,exclude);
                }
            }
        }
        return currRow[W];
        //Time  Complexity - O(nW)
        //Space Complexity - O(W)
    }
    // Function to return max value that can be put in knapsack of capacity.

    static int knapSack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        // int[][] dp = new int[n][W+1];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<W+1;j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return solve_dp(0,W,wt,val,dp);
        return solve_more_opt(W, wt, val);
    }
}
//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1