package algorithms.prefixSum;

import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;

        for(int i : nums){
            prefixSum += i;
            int remainder = prefixSum%k;

            // Handle negative remainders by adding k
            if (remainder < 0) {
                remainder += k;
            }

            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder,0) + 1);
        }
        return count;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    //https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1578136002/
}
