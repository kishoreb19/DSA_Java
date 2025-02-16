package dynamicProgramming;

public class LongestPalindromicSubsequence {

    int solve_rec(int i, int j, String s){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }

        int ans = 0;
        if(s.charAt(i) == s.charAt(j)){
            ans = 2 + solve_rec(i+1,j-1,s);
        }else{
            int x = solve_rec(i+1,j,s);
            int y = solve_rec(i,j-1,s);
            ans = Math.max(x,y);
        }
        return ans;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int i, int j, String s, int[][] dp){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;
        if(s.charAt(i) == s.charAt(j)){
            ans = 2 + solve_dp(i+1,j-1,s,dp);
        }else{
            int x = solve_dp(i+1,j,s,dp);
            int y = solve_dp(i,j-1,s,dp);
            ans = Math.max(x,y);
        }
        return dp[i][j] = ans;
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2) + O(n)
    }

    int solve_tab(String s){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<n; i++){// Single character is always a palindrome
            dp[i][i] = 1;
        }

        for(int i=n-1; i>=0 ;i--){
            for(int j=i+1; j<=n-1; j++){
                int ans = 0;
                if(s.charAt(i) == s.charAt(j)){
                    ans = 2 + dp[i+1][j-1];
                }else{
                    int x = dp[i+1][j];
                    int y = dp[i][j-1];
                    ans = Math.max(x,y);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2)
    }

    int solve_opt(String s){//Something is wrong here
        int n = s.length();
        if(n==1){
            return 1;
        }
        int[] currRow = new int[n+1];
        int[] nextRow = new int[n+1];

        for(int i=0; i<n; i++){// Single character is always a palindrome
            nextRow[i] = 1;
            currRow[i] = 1;
        }

        for(int i=n-1; i>=0 ;i--){
            for(int j=i+1; j<=n-1; j++){
                int ans = 0;
                if(s.charAt(i) == s.charAt(j)){
                    ans = 2 + nextRow[j-1];
                }else{
                    int x = nextRow[j];
                    int y = currRow[j-1];
                    ans = Math.max(x,y);
                }
                currRow[j] = ans;
            }
            nextRow = currRow.clone();
        }
        return currRow[n-1];
        //Time  Complexity - O(m*n)
        //Space Complexity - O(m*n)
    }

    int lcs(String s1, String s2){
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
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n)
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // return solve_rec(0,n-1,s);

        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,n-1,s,dp);
        // return solve_tab(s);
        // return solve_opt(s); //Something is wrong here
        String revStr = new StringBuilder(s).reverse().toString();
        return lcs(s,revStr);
    }
    //https://leetcode.com/problems/longest-palindromic-subsequence/
}
