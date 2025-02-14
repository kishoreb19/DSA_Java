package dynamicProgramming;

import java.util.Arrays;

public class ReducingDishes {
    int solve_rec(int i, int time, int[] satisfaction){
        int n = satisfaction.length;
        if(i==n){
            return 0;
        }
        int include = (time+1) * satisfaction[i] + solve_rec(i+1,time+1,satisfaction);
        int exclude = 0 + solve_rec(i+1,time,satisfaction);
        return Math.max(include,exclude);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int i, int time, int[] satisfaction, int[][] dp){
        int n = satisfaction.length;
        if(i==n){
            return 0;
        }
        if(dp[i][time] != -1){
            return dp[i][time];
        }
        int include = (time+1) * satisfaction[i] + solve_dp(i+1,time+1,satisfaction,dp);
        int exclude = 0 + solve_dp(i+1,time,satisfaction,dp);
        return dp[i][time] = Math.max(include,exclude);
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(int[] satisfaction){
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            dp[n][i] = 0;
        }

        for(int i=n-1; i>=0; i--){
            for(int time=n-1; time>=0; time--){
                int include = (time+1) * satisfaction[i] + dp[i+1][time+1];
                int exclude = 0 + dp[i+1][time];
                dp[i][time] = Math.max(include,exclude);
            }
        }
        return dp[0][0];
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2)
    }

    int solve_opt(int[] satisfaction){
        int n = satisfaction.length;
        int[] currRow = new int[n+1];
        int[] nextRow = new int[n+1];

        Arrays.sort(satisfaction);

        // for(int i=0; i<=n; i++){
        //     dp[n][i] = 0;
        // }

        for(int i=n-1; i>=0; i--){
            for(int time=n-1; time>=0; time--){
                int include = (time+1) * satisfaction[i] + nextRow[time+1];
                int exclude = 0 + nextRow[time];
                currRow[time] = Math.max(include,exclude);
            }
            nextRow = currRow.clone();
        }

        return currRow[0];
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        // return solve_dp(0,0,satisfaction,dp);
        return solve_opt(satisfaction);
    }
    //https://leetcode.com/problems/reducing-dishes/
}
