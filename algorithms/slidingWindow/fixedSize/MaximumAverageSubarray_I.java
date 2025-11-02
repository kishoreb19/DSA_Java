package algorithms.slidingWindow.fixedSize;

public class MaximumAverageSubarray_I {
    public double findMaxAverage(int[] nums, int k) {

        double sum = 0;

        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        double maxAvg = sum/k;

        for(int i=k; i<nums.length; i++){
            sum = sum + nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg,sum/k);
        }
        return maxAvg;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/maximum-average-subarray-i/submissions/1643325771/
}
