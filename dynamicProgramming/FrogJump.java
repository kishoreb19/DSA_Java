package dynamicProgramming;

public class FrogJump {
    static int solve_rec(int i, int h[]){
        if(i==0){
            return 0;
        }
        int l = Math.abs(h[i]-h[i-1]) + solve_rec(i-1, h);
        int r = (i-2>=0 ? Math.abs(h[i]-h[i-2]) + solve_rec(i-2, h) : Integer.MAX_VALUE);

        return Math.min(l,r);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int i, int h[], int dp[]){
        if(i==0) return dp[i]=0;
        if(dp[i]==-1){
            int l = Math.abs(h[i]-h[i-1]) + solve_dp(i-1, h,dp);
            int r = (i-2>=0 ? Math.abs(h[i]-h[i-2]) + solve_dp(i-2, h,dp) : Integer.MAX_VALUE);
            dp[i] = Math.min(l,r);
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    static int solve_tab(int i, int h[]){
        if(i==0) return 0;

        int n = h.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int j=1;j<n;j++){
            int l = Math.abs(h[j]-h[j-1]) + dp[j-1];
            int r = (j-2>=0 ? Math.abs(h[j]-h[j-2]) + dp[j-2] : Integer.MAX_VALUE);
            dp[j] = Math.min(l,r);
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    static int solve_space_optimized(int i, int h[]){
        int n = h.length;
        int prev1 = 0;
        int prev2 = 0;
        for(int j = 1;j<n;j++){
            int l = Math.abs(h[j]-h[j-1]) + prev1;
            int r = (j-2>=0 ? Math.abs(h[j]-h[j-2]) + prev2 : Integer.MAX_VALUE);
            int curr = Math.min(l,r);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }

    public static int frogJump(int n, int heights[]) {

        // Write your code here..

        // //solve_rec()
        // return solve_rec(n-1, heights);

        // //solve_dp
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // return solve_dp(n-1,heights,dp);

        // //solve_tab()
        // return solve_tab(n-1,heights);

        //solve_space_optimized()
        return solve_space_optimized(n-1, heights);
    }
    //https://www.naukri.com/code360/problems/frog-jump_3621012?leftPanelTabValue=PROBLEM
}
