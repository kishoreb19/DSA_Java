package array;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;

        int[] arr = new int[nums.length];

        //Even indices will store +ve values
        //While odd indices will store -ve values
        for (int num : nums) {
            if (num > 0) {
                arr[pos] = num;
                pos += 2;
            } else {
                arr[neg] = num;
                neg += 2;
            }
        }
        return arr;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }

    //https://leetcode.com/problems/rearrange-array-elements-by-sign/
}
