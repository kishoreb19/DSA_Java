package algorithms;

public class MooreVotingAlgorithm {

    // The Moore’s Voting Algorithm is used to find the majority element in an array —
    // i.e., an element that appears more than n/2 times in the array.

    // Idea Behind the Algorithm

    // Think of it like a voting system:
    // Every number is a candidate.
    // Every occurrence is a vote.
    // The majority element will always survive even if all others are cancelled out.

    // We use a count and a candidate:

    // If count == 0, choose the current number as the new candidate.
    // If the next number is the same as candidate, increase the count.
    // Otherwise, decrease the count (cancel out one vote).

    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }

            if(candidate == num){
                count++;
            }else{
                count--;
            }
        }

        // Phase 2: Verify candidate (optional if majority guaranteed)
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) freq++;
        }
        if (freq > nums.length / 2)
            return candidate;
        else
            return -1; // No majority element

        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/majority-element/
}