package array;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    //Optimal Solution
    public int longestConsecutive_optimal(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //Add elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // start of a new sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                //Check if next consecutive element is present
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int prevSmaller = Integer.MIN_VALUE;
        int longest = 0;
        int count = 0;

        for(int i : nums){
            //Skip duplicate values
            if (prevSmaller == i) continue;

            if(prevSmaller != i-1){
                prevSmaller = i;
                count = 1;
            }else if (prevSmaller == i-1){
                prevSmaller = i;
                count++;
            }
            longest = Math.max(longest,count);
        }
        return longest;
        //Time  Complexity - O(NlogN)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/longest-consecutive-sequence/
    //https://www.youtube.com/watch?v=oO5uLE7EUlM&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=13
}
