package dynamicProgramming;

public class LongestCommonSubsequence {

    int solve_rec(int i, int j, String s1, String s2){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + solve_rec(i+1,j+1,s1,s2);
        }else{
            int x = solve_rec(i+1,j,s1,s2);
            int y = solve_rec(i,j+1,s1,s2);
            ans = Math.max(x,y);
        }
        return ans;
        //Time  Complexity - O(2^(max(m,n)))
        //Space Complexity - O(m+n)
    }

    int solve_dp(int i, int j, String s1, String s2, int[][] dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + solve_dp(i+1,j+1,s1,s2,dp);
        }else{
            int x = solve_dp(i+1,j,s1,s2,dp);
            int y = solve_dp(i,j+1,s1,s2,dp);
            ans =  Math.max(x,y);
        }
        return dp[i][j] = ans;
        //Time  Complexity - O(m*n)
        //Space Complexity - O(m×n)+O(m+n) -> O(m×n)
    }
    int solve_tab(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];

        for(int i=n1-1; i>=0 ;i--){
            for(int j=n2-1; j>=0; j--){
                int ans = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    ans = 1 + dp[i+1][j+1];
                }else{
                    int x = dp[i+1][j];
                    int y = dp[i][j+1];
                    ans =  Math.max(x,y);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
        //Time  Complexity - O(m*n)
        //Space Complexity - O(m*n)
    }

    int solve_opt(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[] currRow = new int[n2+1];
        int[] nextRow = new int[n2+1];

        for(int i=n1-1; i>=0 ;i--){
            for(int j=n2-1; j>=0; j--){
                int ans = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    ans = 1 + nextRow[j+1];
                }else{
                    int x = nextRow[j];
                    int y = currRow[j+1];
                    ans =  Math.max(x,y);
                }
                currRow[j] = ans;
            }
            nextRow = currRow.clone();
        }
        return currRow[0];
        //Time  Complexity - O(m*n)
        //Space Complexity - O(n)
    }
    public int longestCommonSubsequence(String s1, String s2) {
        // return solve_rec(0,0,s1,s2);
        // int dp[][] = new int[s1.length()][s2.length()];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,0,s1,s2,dp);
        return solve_opt(s1,s2);
    }
    //https://leetcode.com/problems/longest-common-subsequence/
}
