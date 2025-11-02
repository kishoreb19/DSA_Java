package array;

import java.util.*;

public class LongestSubarrayWithSumK {

    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int max = 0;

        int prefixSum = 0;
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];

            if(map.containsKey(prefixSum - k)){
                max = Math.max(max, i - map.get(prefixSum - k));
            }
            //We will store only the 1st occurrence index to get maximum
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }

        }
        return max;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    //https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
}
