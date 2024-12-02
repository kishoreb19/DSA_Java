package dynamicProgramming;

public class MinimumCoins {
    static int solve_rec(int x, int num[]){
        if(x<0){
            return Integer.MAX_VALUE;
        }
        if(x==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i : num){
            int ans = solve_rec(x-i,num);
            if(ans!=Integer.MAX_VALUE){
                min = Math.min(min,ans+1);
            }
        }
        return min;
    }

    static int solve_dp(int x, int[] num, int[] dp){
        if(x<0) return Integer.MAX_VALUE;
        if(x==0) return 0;

        if(dp[x]==-1){
            int min = Integer.MAX_VALUE;
            for(int i : num){
                int ans = solve_dp(x-i,num,dp);
                if(ans!=Integer.MAX_VALUE){
                    min = Math.min(min,ans+1);
                }
            }
            dp[x] = min;
        }
        return dp[x];
        //Time  Complexity - O(x*num)
        //Space Complexity - O(x)
    }

    static int solve_tab(int x, int num[]){
        if(x<0) return Integer.MAX_VALUE;
        if(x==0) return 0;

        int dp[] = new int[x+1];
        dp[0] = 0;
        for(int i=1;i<=x;i++){
            int min = Integer.MAX_VALUE;
            for(int j : num){
                int ans = i-j>=0 ? dp[i-j]:Integer.MAX_VALUE;
                if(ans!=Integer.MAX_VALUE){
                    min = Math.min(min,ans+1);
                }
            }
            dp[i] = min;
        }
        return dp[x]!=Integer.MAX_VALUE ? dp[x]:-1;
        //Time  Complexity - O(x*num)
        //Space Complexity - O(x)
    }
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        // //solve_rec()
        // int ans = solve_rec(x,num);
        // return ans!=Integer.MAX_VALUE ? ans:-1;

        // //solve_dp()
        // int dp[] = new int[x+1];
        // Arrays.fill(dp,-1);
        // int ans = solve_dp(x,num,dp);
        // return ans!=Integer.MAX_VALUE ? ans:-1;

        //solve_tab()
        int ans = solve_tab(x,num);
        return ans;
    }
    //https://www.naukri.com/code360/problems/minimum-elements_3843091?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
