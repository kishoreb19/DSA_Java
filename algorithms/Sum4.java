package algorithms;
import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Sort the array first
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            //Skip duplicates for i
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                //Skip duplicates for j
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k= j+1;
                int l = n-1;

                while(k<l){
                    //Don't take int as multiple addition can cause integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target){
                        List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        result.add(ans);

                        //Skip duplicates for k
                        while(k<l && nums[k] == nums[k+1]){
                            k++;
                        }
                        //Skip duplicates for l
                        while(k<l && nums[l] == nums[l-1]){
                            l--;
                        }

                        k++; l--;
                    }else if(sum>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return result;
        //Time  Complexity - O(NlogN) x O(N2 x N) ~ O(N3)
        //Space Complexity (Auxiliary Space) - O(1) (ignoring output)
        //Space Complexity - O(M)
        //where m is the number of valid quadruplets.
    }
    //https://leetcode.com/problems/4sum/
}
