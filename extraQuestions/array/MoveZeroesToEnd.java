package extraQuestions.array;

public class MoveZeroesToEnd {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int t = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = t;
                nonZeroIndex++;
            }
        }
    }
    //Time Complexity- O(N)
    //Space Complexity - O(1)
    //https://leetcode.com/problems/move-zeroes/description
}
