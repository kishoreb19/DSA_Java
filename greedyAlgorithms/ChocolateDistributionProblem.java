package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {

    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int n = arr.size();
        if(m>n){
            return -1;
        }
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;

        int i=0, j = m-1;
        while(j<n){
            min = Math.min(min, arr.get(j)-arr.get(i));
            i++;
            j++;
        }
        return min;
        //Time  Complexity - O(n)
        //Space Complexity - O(1)
    }
}
