package dynamicProgramming;

public class DiceThrows {
    static int solve_rec(int currDice, int n, int m, int sum){
        if(currDice>n){
            if(sum==0){
                return 1;
            }else{
                return 0;
            }
        }
        int ans = 0;
        for(int i=1; i<=m; i++){
            ans = ans + solve_rec(currDice+1,n,m,sum-i);
        }
        return ans;
        //Time  Complexity - O(m^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int currDice, int n, int m, int sum, int[][] dp){
        if (sum < 0) return 0;
        if(currDice>n){
            if(sum==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[currDice][sum] != -1){
            return dp[currDice][sum];
        }
        int ans = 0;
        for(int i=1; i<=m; i++){
            ans = ans + solve_dp(currDice+1,n,m,sum-i,dp);
        }
        return dp[currDice][sum] = ans;
        //Time  Complexity - O(n * sum * m)
        //Space Complexity - O(n * sum) + O(n) = O(n * sum)
    }

    static int solve_tab(int m, int n, int x) {
        int[][] dp = new int[n+1][x+1];

        // Base case: If we have 0 dice and sum = 0, there's 1 way (do nothing)
        dp[0][0] = 1;

        // Iterating over number of dice
        for(int currDice = 1; currDice <= n; currDice++) {
            for(int sum = 0; sum <= x; sum++) {
                int ans = 0;
                for(int i = 1; i <= m; i++) {
                    if (sum - i >= 0) {
                        ans += dp[currDice - 1][sum - i];
                    }
                }
                dp[currDice][sum] = ans;
            }
        }
        return dp[n][x]; // Answer is the number of ways to get sum `x` using `n` dice
        //Time  Complexity - O(n * x * m)
        //Space Complexity - O(n * x)
    }

    static int solve_opt(int m, int n, int x) {
        int[] currRow = new int[x+1];
        int[] nextRow = new int[x+1];

        // Base case: If we have 0 dice and sum = 0, there's 1 way (do nothing)
        nextRow[0] = 1;

        // Iterating over number of dice
        for(int currDice = 1; currDice <= n; currDice++) {
            for(int sum = 0; sum <= x; sum++) {
                int ans = 0;
                for(int i = 1; i <= m; i++) {
                    if (sum - i >= 0) {
                        ans += nextRow[sum - i];
                    }
                }
                currRow[sum] = ans;
            }
            nextRow = currRow.clone();
        }
        return currRow[x]; // Answer is the number of ways to get sum `x` using `n` dice
        //Time  Complexity - O(n * x * m)
        //Space Complexity - O(x)
    }

    static int noOfWays(int m, int n, int x) {
        // code here
        // int[][] dp = new int[n+1][x+1];
        // for(int i=0;i<n+1; i++){
        //     for(int j=0; j<x+1; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return solve_dp(1,n,m,x,dp);
        return solve_opt(m,n,x);
    }
    //https://www.geeksforgeeks.org/problems/dice-throw5349/1
}
