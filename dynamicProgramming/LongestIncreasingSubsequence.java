package dynamicProgramming;

import java.util.*;
public class LongestIncreasingSubsequence {

    static int solve_rec(int curr, int prev, int[] arr){
        int n = arr.length;
        if(curr == n){
            return 0;
        }

        if(prev == -1 || arr[curr] > arr[prev]){
            int take = 1 + solve_rec(curr+1, curr, arr);
            int notTake = solve_rec(curr+1, prev, arr);
            return Math.max(take, notTake);
        }else{
            return solve_rec(curr+1, prev, arr);
        }
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int curr, int prev, int[] arr, int[][] dp){
        int n = arr.length;
        if(curr == n){
            return 0;
        }

        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        if(prev == -1 || arr[curr] > arr[prev]){
            int take = 1 + solve_dp(curr+1, curr, arr,dp);
            int notTake = solve_dp(curr+1, prev, arr,dp);
            return dp[curr][prev+1] = Math.max(take, notTake);
        }else{
            return dp[curr][prev+1] = solve_dp(curr+1, prev, arr, dp);
        }
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2) + O(n)
    }

    static int solve_tab(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        // for(int prev = -1; prev<n; prev++){
        //     dp[n][prev+1] = 0;
        // }

        for(int curr = n-1; curr>=0; curr--){
            for(int prev = n-1; prev>=-1; prev--){
                if(prev == -1 || arr[curr] > arr[prev]){
                    int take = 1 + dp[curr+1][curr+1];
                    int notTake = dp[curr+1][prev+1];
                    dp[curr][prev+1] = Math.max(take, notTake);
                }else{
                    dp[curr][prev+1] = dp[curr+1][prev+1];
                }
            }
        }
        return dp[0][-1+1];
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n^2)
    }

    static int solve_opt(int[] arr){
        int n = arr.length;
        int[] currRow = new int[n+1];
        int[] nextRow = new int[n+1];

        for(int curr = n-1; curr>=0; curr--){
            for(int prev = n-1; prev>=-1; prev--){
                if(prev == -1 || arr[curr] > arr[prev]){
                    int take = 1 + nextRow[curr+1];
                    int notTake = nextRow[prev+1];
                    currRow[prev+1] = Math.max(take, notTake);
                }else{
                    currRow[prev+1] = nextRow[prev+1];
                }
            }
            nextRow = currRow.clone();
        }
        return currRow[0];
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n)
    }

    static int solve_more_opt(int n, int[] a) {
        if (n == 0) return 0;

        List<Integer> ans = new ArrayList<>();
        ans.add(a[0]);

        for (int i = 1; i < n; i++) {
            if (a[i] > ans.get(ans.size() - 1)) {
                ans.add(a[i]);  // Append to LIS
            } else {
                // Find the first element >= a[i] using binary search
                int index = Collections.binarySearch(ans, a[i]);
                if (index < 0) index = -(index + 1);  // Get insertion point
                ans.set(index, a[i]);  // Replace with the smaller value
            }
        }

        return ans.size();  // Length of LIS
        //Time  Complexity - O(nlogn)
        //Space Complexity - O(n)
    }

    // Function to find length of longest increasing subsequence.
    static int lis(int[] arr) {
        // code here
        int n = arr.length;
        // int[][] dp = new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n+1; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return solve_dp(0,-1,arr,dp);
        // return solve_opt(arr);
        return solve_more_opt(n,arr);
    }
    //https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
}
