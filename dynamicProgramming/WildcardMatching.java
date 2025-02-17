package dynamicProgramming;

import java.util.Arrays;

public class WildcardMatching {

    boolean solve_rec(int i, int j, String s, String p){
        if(i<0 && j<0){
            return true;
        }
        if(j<0 && i>=0){
            return false;
        }
        if(i<0 && j>=0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return solve_rec(i-1,j-1,s,p);
        }else if(p.charAt(j) == '*'){
            return solve_rec(i,j-1,s,p) || solve_rec(i-1,j,s,p);
        }else{
            return false;
        }
        //Time  Complexity - O(2^(n+m))
        //Space Complexity - O(n+m)
    }

    int solve_dp(int i, int j, String s, String p, int[][] dp){
        if(i<0 && j<0){
            return 1;
        }
        if(j<0 && i>=0){
            return 0;
        }
        if(i<0 && j>=0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k) != '*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = solve_dp(i-1,j-1,s,p,dp);
        }else if(p.charAt(j) == '*'){
            return dp[i][j] = (solve_dp(i,j-1,s,p,dp) | solve_dp(i-1,j,s,p,dp));
        }else{
            return dp[i][j] = 0;
        }
        //Time  Complexity - O(n*m)
        //Space Complexity - O(n*m) + O(n+m)
    }

    //Converting into 1-Based Indexing to handle i<0 and j<0

    int solve_dp_1(int i, int j, String s, String p, int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(j==0 && i>0){
            return 0;
        }
        if(i==0 && j>0){
            for(int k=1; k<=j; k++){
                if(p.charAt(k-1) != '*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            return dp[i][j] = solve_dp_1(i-1,j-1,s,p,dp);
        }else if(p.charAt(j-1) == '*'){
            return dp[i][j] = (solve_dp_1(i,j-1,s,p,dp) | solve_dp_1(i-1,j,s,p,dp));
        }else{
            return dp[i][j] = 0;
        }
        //Time  Complexity - O(n*m)
        //Space Complexity - O(n*m) + O(n+m)
    }

    int solve_tab(String s, String p){
        int n1 = s.length();
        int n2 = p.length();

        int[][] dp = new int[n1+1][n2+1];

        //Handling Base Cases

        //1st base case
        dp[0][0] = 1;

        //2nd base case -> Nothing to do as dp is already initialised with 0

        //3rd base case
        for(int j=1; j<=n2; j++){
            int flag = 1;
            for(int k=1; k<=j; k++){
                if(p.charAt(k-1) != '*'){
                    flag = 0;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = (dp[i][j-1] | dp[i-1][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n1][n2];
        //Time  Complexity - O(n*m)
        //Space Complexity - O(n*m)
    }

    int solve_opt(String s, String p){
        int n1 = s.length();
        int n2 = p.length();

        int[] currRow = new int[n2+1];
        int[] prevRow = new int[n2+1];

        //Handling Base Cases

        //1st base case
        prevRow[0] = 1;

        //2nd base case -> Nothing to do as dp is already initialised with 0

        //3rd base case
        for(int j=1; j<=n2; j++){
            int flag = 1;
            for(int k=1; k<=j; k++){
                if(p.charAt(k-1) != '*'){
                    flag = 0;
                    break;
                }
            }
            prevRow[j] = flag;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    currRow[j] = prevRow[j-1];
                }else if(p.charAt(j-1) == '*'){
                    currRow[j] = (currRow[j-1] | prevRow[j]);
                }else{
                    currRow[j] = 0;
                }
            }
            prevRow = currRow.clone();
        }
        return prevRow[n2];
        //Time  Complexity - O(n*m)
        //Space Complexity - O(m)
    }
    public boolean isMatch(String s, String p) {
        // return solve_rec(s.length()-1,p.length()-1,s,p);
        int n1 = s.length();
        int n2 = p.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        // return  solve_dp(n1-1,n2-1,s,p,dp)==1;
        // //1 - Based Indexing
        // return  solve_dp_1(n1-1+1,n2-1+1,s,p,dp)==1;

        // return solve_tab(s,p) == 1;
        return solve_opt(s,p) == 1;
    }
    //https://leetcode.com/problems/wildcard-matching/
}