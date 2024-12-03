package dynamicProgramming;

public class CombinationSumIV {
    static int solve_rec(int x, int num[]){
        if(x==0) return 1;//There's only one way to make zero so 1
        if(x<0)  return 0;

        int ways = 0;
        for(int i : num){
            ways+= solve_rec(x-i, num);
        }

        return ways;
        //Time  Complexity - O(num.length^x)
        //Space Complexity - O(x)
    }

    static int solve_dp(int x, int num[], int dp[]){
        if(x==0) return 1;
        if(x<0)  return 0;

        if(dp[x] != -1){
            return dp[x];
        }

        int ways = 0;
        for(int i : num){
            ways+= solve_dp(x-i, num,dp);
        }

        return dp[x] = ways;
        //Time  Complexity - O(num.length * x)
        //Space Complexity - O(x) + O(x)
    }

    static int solve_tab(int x, int num[]){
        if(x==0) return 1;
        if(x<0)  return 0;

        int dp[] = new int[x+1];
        dp[0] = 1;

        for(int j=1;j<=x;j++){
            int ways = 0;
            for(int i : num){
                ways+= j-i>=0 ? dp[j-i]:0;
            }

            dp[j] = ways;
        }
        return dp[x];
        //Time  Complexity - O(num.length * x)
        //Space Complexity - O(x)
    }
    //Space Optimization not possible since we can't track prev variables because of num
    public static int findWays(int num[], int x) {
        // Write your code here..

        // //solve_rec();
        // return solve_rec(x,num);

        // //solve_dp()
        // int dp[] = new int[x+1];
        // Arrays.fill(dp,-1);
        // return solve_dp(x, num, dp);

        //solve_tab()
        return solve_tab(x, num);
    }
    //https://www.naukri.com/code360/problems/number-of-ways_3755252?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
