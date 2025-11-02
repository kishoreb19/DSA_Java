package algorithms.prefixSum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        for(int i : nums){
            prefixSum += i;
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    //https://leetcode.com/problems/subarray-sum-equals-k/
}
