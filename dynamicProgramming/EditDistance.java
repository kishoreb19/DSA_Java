package dynamicProgramming;

public class EditDistance {
    int solve_rec(int i, int j, String s1, String s2){
        if(i == s1.length()){
            return s2.length() - j;
        }
        if(j == s2.length()){
            return s1.length() - i;
        }
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = solve_rec(i+1,j+1,s1,s2);
        }else{
            int insert = 1 + solve_rec(i,j+1,s1,s2);
            int delete = 1 + solve_rec(i+1,j,s1,s2);
            int replace =1 + solve_rec(i+1,j+1,s1,s2);

            ans = Math.min(insert,Math.min(delete,replace));
        }
        return ans;
        //Time  Complexity - O(3^max(n1,n2))
        //Space Complexity - O(max(n1,n2))
    }

    int solve_dp(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length()){
            return s2.length() - j;
        }
        if(j == s2.length()){
            return s1.length() - i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = solve_dp(i+1,j+1,s1,s2,dp);
        }else{
            int insert = 1 + solve_dp(i,j+1,s1,s2,dp);
            int delete = 1 + solve_dp(i+1,j,s1,s2,dp);
            int replace =1 + solve_dp(i+1,j+1,s1,s2,dp);

            ans = Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j] = ans;
        //Time  Complexity - O(n1*n2)
        //Space Complexity - O(n1*n2) + O(max(n1,n2))
    }

    int solve_tab(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int j=0; j<n2; j++){
            dp[n1][j] = n2-j;
        }
        for(int i=0; i<n1; i++){
            dp[i][n2] = n1-i;
        }

        for(int i = n1-1; i>=0; i--){
            for(int j = n2-1; j>=0; j--){
                int ans = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    ans = dp[i+1][j+1];
                }else{
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    int replace =1 + dp[i+1][j+1];

                    ans = Math.min(insert,Math.min(delete,replace));
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
        //Time  Complexity - O(n1*n2)
        //Space Complexity - O(n1*n2)
    }

    int solve_opt(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 == 0){
            return n2;
        }
        if(n2 == 0){
            return n1;
        }

        int[] currRow = new int[n2 + 1];
        int[] nextRow = new int[n2 + 1];

        for(int j=0; j<n2; j++){
            nextRow[j] = n2-j;
        }
        // for(int i=0; i<n1; i++){
        //     dp[i][n2] = n1-i;
        // }

        for(int i = n1-1; i>=0; i--){
            for(int j = n2-1; j>=0; j--){
                //Main Catch here
                currRow[n2] = n1 - i;
                int ans = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    ans = nextRow[j+1];
                }else{
                    int insert = 1 + currRow[j+1];
                    int delete = 1 + nextRow[j];
                    int replace =1 + nextRow[j+1];

                    ans = Math.min(insert,Math.min(delete,replace));
                }
                currRow[j] = ans;
            }
            nextRow = currRow.clone();
        }
        return currRow[0];
        //Time  Complexity - O(n1*n2)
        //Space Complexity - O(n2)
    }
    public int minDistance(String s1, String s2) {
        // int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,0,s1,s2,dp);
        // return solve_tab(s1,s2);
        return solve_opt(s1,s2);
    }
    //https://leetcode.com/problems/edit-distance/
}
