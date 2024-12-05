package searching.problems;

public class ValidMountain {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;//Mountain array should have at least 3 elements

        int i=0;
        while(i+1<n && arr[i]<arr[i+1]){//Climb up
            i++;
        }

        //If the hiker is at the first or last element, it's not a valid mountain.
        if(i==0 || i==(n-1)){
            return false;
        }

        while(i+1<n && arr[i]>arr[i+1]){//Climb down
            i++;
        }
        //if hiker is now at the last element, it's a valid mountain!
        return i==(n-1);
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/valid-mountain-array/
}