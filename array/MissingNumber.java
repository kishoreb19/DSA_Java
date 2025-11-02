package array;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            xor1 = xor1 ^ nums[i];
            xor2 = xor2 ^ (i+1);
        }
        return xor1 ^ xor2;

        //xor1 = 1^2^3^5
        //xor2 = 1^2^3^4^5
        //XOR operation cancels (0) out same elements so you are left with missing no. 5
    }

    //Another Method

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum1 = (n*(n+1))/2;
        int sum2 = 0;

        for(int i : nums){
            sum2 += i;
        }
        return sum1 - sum2;
    }
    //For Both Methods
    //Time  Complexity - O(N)
    //Space Complexity - O(1)
    //https://leetcode.com/problems/missing-number/
}
