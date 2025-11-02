package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] arr) {
        // Step 1: Sort by start time, then by end time
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> ans = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) { // overlap
                end = Math.max(end, arr[i][1]);
            } else { // no overlap
                ans.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // Step 3: Don't forget the last interval
        ans.add(new int[]{start, end});

        // Step 4: Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
        //Time  Complexity - O(NlogN)
        //Space Complexity - O(N)
    }
    //https://leetcode.com/problems/merge-intervals/
}
