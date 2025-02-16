package dynamicProgramming;

public class BestTimeToBuyAndSellStock_III {
    int solve_rec(int i, boolean buy, int limit, int[] prices){
        int n = prices.length;
        if(i==n || limit<=0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if(buy){
            int take = -prices[i] + solve_rec(i+1, false, limit, prices);
            int notTake = 0 + solve_rec(i+1,true,limit,prices);
            max = Math.max(take,notTake);
        }else{
            int sell = prices[i] + solve_rec(i+1,true,limit-1,prices);
            int notSell = 0 + solve_rec(i+1,false,limit,prices);
            max = Math.max(sell,notSell);
        }
        return max;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int i, int buy, int limit, int[] prices, int[][][] dp){
        int n = prices.length;
        if(i==n || limit<=0){
            return 0;
        }
        if(dp[i][buy][limit] != -1){
            return dp[i][buy][limit];
        }
        int max = Integer.MIN_VALUE;
        if(buy == 1){
            int take = -prices[i] + solve_dp(i+1, 0, limit, prices,dp);
            int notTake = 0 + solve_dp(i+1,1,limit,prices,dp);
            max = Math.max(take,notTake);
        }else{
            int sell = prices[i] + solve_dp(i+1,1,limit-1,prices,dp);
            int notSell = 0 + solve_dp(i+1,0,limit,prices,dp);
            max = Math.max(sell,notSell);
        }
        return dp[i][buy][limit] = max;
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    int solve_tab(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int limit=1; limit<=2; limit++){
                    int max = Integer.MIN_VALUE;
                    if(buy == 1){
                        int take = -prices[i] + dp[i+1][0][limit];
                        int notTake = 0 + dp[i+1][1][limit];
                        max = Math.max(take,notTake);
                    }else{
                        int sell = prices[i] + dp[i+1][1][limit-1];
                        int notSell = 0 + dp[i+1][0][limit];
                        max = Math.max(sell,notSell);
                    }
                    dp[i][buy][limit] = max;
                }
            }
        }
        return dp[0][1][2];
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    int solve_opt(int[] prices){
        int n = prices.length;
        int[][] currRow = new int[2][3];
        int[][] nextRow = new int[2][3];

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int limit=1; limit<=2; limit++){
                    int max = Integer.MIN_VALUE;
                    if(buy == 1){
                        int take = -prices[i] + nextRow[0][limit];
                        int notTake = 0 + nextRow[1][limit];
                        max = Math.max(take,notTake);
                    }else{
                        int sell = prices[i] + nextRow[1][limit-1];
                        int notSell = 0 + nextRow[0][limit];
                        max = Math.max(sell,notSell);
                    }
                    currRow[buy][limit] = max;
                }
                nextRow = currRow.clone();
            }
        }
        return currRow[1][2];
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n+1][2][3];
        // for(int[][] row1 : dp){
        //     for(int[] row : row1){
        //         Arrays.fill(row,-1);
        //     }
        // }
        // return solve_dp(0,1,2,prices,dp);
        // return solve_tab(prices);
        return solve_opt(prices);
    }
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
}
