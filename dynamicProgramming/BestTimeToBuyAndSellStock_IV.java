package dynamicProgramming;

public class BestTimeToBuyAndSellStock_IV {

    int solve_rec(int i, int operations, int k, int[] prices){
        int n = prices.length;
        if(i==n){
            return 0;
        }
        if(operations >= 2*k){
            return 0;
        }
        int max = 0;
        if((operations & 1) == 0){//Even -> Buy
            int take = -prices[i] + solve_rec(i+1,operations+1,k,prices);
            int notTake = 0 + solve_rec(i+1,operations,k,prices);
            max = Math.max(take,notTake);
        }else{//Odd -> Sell
            int sell = prices[i] + solve_rec(i+1,operations+1,k,prices);
            int notSell = 0 + solve_rec(i+1,operations,k,prices);
            max = Math.max(sell,notSell);
        }

        return max;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int i, int operations, int k, int[] prices, int[][] dp){
        int n = prices.length;
        if(i==n){
            return 0;
        }
        if(operations >= 2*k){
            return 0;
        }

        if(dp[i][operations] != -1){
            return dp[i][operations];
        }

        int max = 0;
        if((operations & 1) == 0){//Even -> Buy
            int take = -prices[i] + solve_dp(i+1,operations+1,k,prices,dp);
            int notTake = 0 + solve_dp(i+1,operations,k,prices,dp);
            max = Math.max(take,notTake);
        }else{//Odd -> Sell
            int sell = prices[i] + solve_dp(i+1,operations+1,k,prices,dp);
            int notSell = 0 + solve_dp(i+1,operations,k,prices,dp);
            max = Math.max(sell,notSell);
        }

        return dp[i][operations] = max;
        //Time  Complexity - O(N×2K) -> O(NK)
        //Space Complexity - O(N*K) + O(n)
    }

    int solve_tab(int k, int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][(2*k) + 1];

        for(int i=n-1; i>=0; i--){
            for(int operations = (2*k)-1; operations>=0; operations--){
                int max = 0;
                if((operations & 1) == 0){//Even -> Buy
                    int take = -prices[i] + dp[i+1][operations+1];
                    int notTake = 0 + dp[i+1][operations];
                    max = Math.max(take,notTake);
                }else{//Odd -> Sell
                    int sell = prices[i] + dp[i+1][operations+1];
                    int notSell = 0 + dp[i+1][operations];
                    max = Math.max(sell,notSell);
                }

                dp[i][operations] = max;
            }
        }
        return dp[0][0];
        //Time  Complexity - O(N×2K) -> O(NK)
        //Space Complexity - O(N*K)
    }

    int solve_opt(int k, int[] prices){
        int n = prices.length;
        int[] currRow = new int[(2*k) + 1];
        int[] nextRow = new int[(2*k) + 1];

        for(int i=n-1; i>=0; i--){
            for(int operations = (2*k)-1; operations>=0; operations--){
                int max = 0;
                if((operations & 1) == 0){//Even -> Buy
                    int take = -prices[i] + nextRow[operations+1];
                    int notTake = 0 + nextRow[operations];
                    max = Math.max(take,notTake);
                }else{//Odd -> Sell
                    int sell = prices[i] + nextRow[operations+1];
                    int notSell = 0 + nextRow[operations];
                    max = Math.max(sell,notSell);
                }

                currRow[operations] = max;
            }
            nextRow = currRow.clone();
        }
        return currRow[0];
        //Time  Complexity - O(N×2K) -> O(NK)
        //Space Complexity - O(K)
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][(2*k) + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,0,k,prices,dp);
        // return solve_tab(k,prices);
        return solve_opt(k,prices);
    }
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
}
