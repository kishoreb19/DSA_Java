package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permutations {
    class Solution {

        void solve(List<Integer> temp, List<List<Integer>> result, HashMap<Integer,Boolean> map, int nums[]){
            if(temp.size()==nums.length){
                result.add(new ArrayList<>(temp));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(map.get(i)==false){//If not seen yet
                    temp.add(nums[i]);//Add to temp
                    map.put(i,true);//Mark visited
                    solve(temp,result,map,nums);
                    //Backtrack
                    temp.remove(temp.size()-1);
                    map.put(i,false);
                }
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            HashMap<Integer,Boolean> map = new HashMap<>();//To mark visited indexes

            for(int i=0;i<nums.length;i++){
                map.put(i,false);
            }

            List<Integer> temp = new ArrayList<>();

            solve(temp,result,map,nums);

            return result;
            //Time  Complexity - O(n! x n)
            //Space Complexity - O(n! x n)
            //https://leetcode.com/problems/permutations/
        }
    }
}
