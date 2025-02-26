package greedyAlgorithms;

import java.util.Arrays;

public class MinimumPlatforms {

    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int maxPlatforms = 0;

        int i = 0, j = 0;

        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                maxPlatforms = Math.max(maxPlatforms,count);
                i++;
            }else{
                count--;
                j++;
            }

        }
        return maxPlatforms;
        //Time  Complexity - O(nlogn)
        //Space Complexity - O(1)
    }
}
