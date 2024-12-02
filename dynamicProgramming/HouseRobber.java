package dynamicProgramming;

import java.util.ArrayList;

public class HouseRobber {
    static long solve_space_optimized(int i, ArrayList<Integer> nums){
        if(i<0) return 0;
        if(i==0) return nums.get(0);

        long prev1 = nums.get(0);
        long prev2 = 0;
        for(int j = 1;j<nums.size();j++){
            long curr = Math.max(nums.get(j)+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        //return Math.max(prev1,prev2);
        return prev1;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
    public static long houseRobber(int[] arr) {
        // Write your code here.

        int n = arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];

        ArrayList<Integer>arr1 = new ArrayList<>();
        ArrayList<Integer>arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i!=n-1){
                arr1.add(arr[i]);
            }
            if(i!=0){
                arr2.add(arr[i]);
            }
        }
        return Math.max(solve_space_optimized(arr1.size()-1, arr1),solve_space_optimized(arr2.size()-1, arr2));
        //Time  Complexity - O(n)
        //Space Complexity - O(n)
    }
    //https://www.naukri.com/code360/problems/house-robber_839733?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=SUBMISSION
}
