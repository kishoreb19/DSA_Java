package dynamicProgramming;

import java.util.ArrayList;

public class MaxSumNonAdjElements {

    static int solve_rec(int i, ArrayList<Integer> nums){
        if(i<0) return 0;
        if(i==0){
            return nums.get(i);
        }
        int inc = nums.get(i) + solve_rec(i-2,nums);
        int exc = 0 + solve_rec(i-1,nums);

        return Math.max(inc,exc);
    }

    static int solve_dp(int i, ArrayList<Integer> nums, int[] dp){
        if(i<0) return 0;
        if(i==0) return nums.get(0);
        dp[0] = nums.get(0);
        if(dp[i]==-1){
            int inc = nums.get(i) + solve_dp(i-2,nums,dp);
            int exc = 0 + solve_dp(i-1,nums,dp);

            dp[i] = Math.max(inc,exc);
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n) + O(n)
    }

    static int solve_tab(int i, ArrayList<Integer> nums){
        if(i<0) return 0;
        if(i==0) return nums.get(0);
        int dp[] = new int[nums.size()];
        dp[0] = nums.get(0);
        for(int j=1;j<nums.size();j++){
            int inc = nums.get(j) + (j-2>=0 ? dp[j-2]:0);
            int exc = 0 + dp[j-1];
            dp[j] = Math.max(inc,exc);
        }
        return dp[i];
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }

    static int solve_space_optimized(int i, ArrayList<Integer> nums){
        if(i<0) return 0;
        if(i==0) return nums.get(0);

        int prev1 = nums.get(0);
        int prev2 = 0;
        for(int j = 1;j<nums.size();j++){
            int curr = Math.max(nums.get(j)+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        //return Math.max(prev1,prev2);
        return prev1;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.

        // //solve_rec()
        // return solve_rec(nums.size()-1,nums);


        // //solve_dp()
        // int n = nums.size();
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return solve_dp(n-1,nums,dp);

        // //solve_tab()
        // int n = nums.size();
        // return solve_tab(n-1,nums);

        //solve_space_optimized()
        int n = nums.size();
        return solve_space_optimized(n-1,nums);
    }
    //https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
}
