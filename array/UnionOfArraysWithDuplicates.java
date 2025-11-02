package array;
import java.util.*;
public class UnionOfArraysWithDuplicates {

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;

        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                if(arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) {
                    arr.add(a[i]);
                }
                i++;
            } else {
                if(arr.isEmpty() || arr.get(arr.size() - 1) != b[j]) {
                    arr.add(b[j]);
                }
                j++;
            }
        }

        while(i < a.length){
            if(arr.isEmpty() || arr.get(arr.size() - 1) != a[i]) {
                arr.add(a[i]);
            }
            i++;
        }

        while(j < b.length){
            if(arr.isEmpty() || arr.get(arr.size() - 1) != b[j]) {
                arr.add(b[j]);
            }
            j++;
        }

        return arr;
        //Time  Complexity - O(n log n + m log m)
        //Space Complexity - O(n + m) (or O(1) auxiliary)
    }
}
