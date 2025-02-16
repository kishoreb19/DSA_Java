package dynamicProgramming;

public class BestTimeToBuyAndSellStock_II {
    int solve_rec(int i, boolean buy, int[] prices){
        int n = prices.length;
        if(i>=n){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if(buy){
            int take = -prices[i] + solve_rec(i+1,false,prices);
            int notTake = 0 + solve_rec(i+1,true,prices);

            max = Math.max(take,notTake);
        }else{
            int sell = prices[i] + solve_rec(i+1,true,prices);
            int notSell = 0 + solve_rec(i+1,false,prices);

            max = Math.max(sell,notSell);
        }
        return max;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int i, int buy, int[] prices, int[][] dp){
        int n = prices.length;
        if(i>=n){
            return 0;
        }

        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int max = Integer.MIN_VALUE;
        if(buy == 1){
            int take = -prices[i] + solve_dp(i+1,0,prices,dp);
            int notTake = 0 + solve_dp(i+1,1,prices,dp);

            max = Math.max(take,notTake);
        }else{
            int sell = prices[i] + solve_dp(i+1,1,prices,dp);
            int notSell = 0 + solve_dp(i+1,0,prices,dp);

            max = Math.max(sell,notSell);
        }
        return dp[i][buy] = max;
        //Time  Complexity - O(2n) -> O(n)
        //Space Complexity - O(2n) + O(n)
    }

    int solve_tab(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=0;i<2;i++){
            dp[n][i] = 0;
        }

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                int max = Integer.MIN_VALUE;
                if(buy == 1){
                    int take = -prices[i] + dp[i+1][0];
                    int notTake = 0 + dp[i+1][1];

                    max = Math.max(take,notTake);
                }else{
                    int sell = prices[i] + dp[i+1][1];
                    int notSell = 0 + dp[i+1][0];

                    max = Math.max(sell,notSell);
                }
                dp[i][buy] = max;
            }
        }
        return dp[0][1];
        //Time  Complexity - O(2n) -> O(n)
        //Space Complexity - O(2n) -> O(n)
    }

    int solve_opt(int[] prices){
        int n = prices.length;
        int[] currRow = new int[2];
        int[] nextRow = new int[2];

        // for(int i=0;i<2;i++){
        //     dp[n][i] = 0;
        // }

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                int max = Integer.MIN_VALUE;
                if(buy == 1){
                    int take = -prices[i] + nextRow[0];
                    int notTake = 0 + nextRow[1];

                    max = Math.max(take,notTake);
                }else{
                    int sell = prices[i] + nextRow[1];
                    int notSell = 0 + nextRow[0];

                    max = Math.max(sell,notSell);
                }
                currRow[buy] = max;
            }
            nextRow = currRow.clone();
        }
        return currRow[1];
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][] dp = new int[n+1][2];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,1,prices,dp);
        return solve_opt(prices);
    }
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
}