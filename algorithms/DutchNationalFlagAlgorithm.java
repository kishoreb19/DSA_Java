package algorithms;

public class DutchNationalFlagAlgorithm {
    void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{//For nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/sort-colors/description/
}
