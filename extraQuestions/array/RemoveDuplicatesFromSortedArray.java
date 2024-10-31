package extraQuestions.array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        return (i-0+1); //Returns size of new array
    }
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    //https://www.youtube.com/watch?v=Fm_p9lJ4Z_8
}
