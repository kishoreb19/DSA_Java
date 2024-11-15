package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_Optimized {
    void swap(int arr[], int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    void solve(int index, int[] nums, List<List<Integer>> result){
        if(index==nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int i : nums){
                ans.add(i);
            }
            result.add(ans);
        }
        for(int i=index; i<nums.length;i++){
            swap(nums,index,i);
            solve(index+1,nums,result);
            //Backtrack
            swap(nums,index,i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0,nums,result);
        return result;
    }
    //Time  Complexity - O(n! x n)
    //Space Complexity - O(n! x n)
    //No extra hashmap is used
    //https://leetcode.com/problems/permutations/
}