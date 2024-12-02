package dynamicProgramming;

public class CutIntoSegments {
    static int solve_rec(int n , int x, int y, int z){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;

        int l = solve_rec(n-x,x,y,z)+1;
        int r = solve_rec(n-y,x,y,z)+1;
        int e = solve_rec(n-z,x,y,z)+1;

        return Math.max(l,Math.max(r,e));
        //At each step, the function makes 3 recursive calls (solve(n-x), solve(n-y), solve(n-z)).
        //The depth of the recursion tree can go up to n.
        
        //Time  Complexity - O(3^n)
        //Space Complexity - O(n)
    }
    static int solve_dp(int n, int x, int y, int z,int dp[]){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;

        if(dp[n]!=-1){
            return dp[n];
        }
        int l = solve_dp(n-x,x,y,z,dp)+1;
        int r = solve_dp(n-y,x,y,z,dp)+1;
        int e = solve_dp(n-z,x,y,z,dp)+1;

        return dp[n] = Math.max(l,Math.max(r,e));
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    static int solve_tab(int n, int x, int y, int z){
        int dp[] = new int[n+1];
        dp[0] = 0;
        int min = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int l = i-x>=0?dp[i-x]+1:min;
            int r = i-y>=0?dp[i-y]+1:min;
            int e = i-z>=0?dp[i-z]+1:min;

            dp[i] = Math.max(l,Math.max(r,e));
        }

        return dp[n]>=0?dp[n]:0;
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }
    public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.

        // //solve_rec()
        // int ans =solve(n,x,y,z);
        // return ans>=0?ans:0;

        //solve_dp()
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans =solve_dp(n,x,y,z,dp);
        // return ans>=0?ans:0;

        //solve_tab()
        return solve_tab(n, x, y, z);

        //Space Optimization Not Possible
    }
}
