package array;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];

            max = Math.max(max, Math.max(prefix,suffix));
        }
        return max;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/maximum-product-subarray/
}
