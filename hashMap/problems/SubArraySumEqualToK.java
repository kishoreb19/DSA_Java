package hashMap.problems;

import java.util.HashMap;

public class SubArraySumEqualToK {
    static int subArrK(int[] arr, int k){
        /*
        sub(x) -> calculates sum till x index
        sub(j) - sub(i-1) = k, where i and j are start and end index
        let sum = sub(j)
        then, sub(j) - k = sub(i-1)
        so,   sum - k = sub(i-1)
        */
        HashMap<Integer,Integer> map = new HashMap<>(); //<Sum,Frequency>
        int sum = 0;
        int ans = 0;
        map.put(0,1); //Empty SubArray sum and its frequency

        for(int i : arr){
            sum += i;
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            //Store frequency of sum
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }

    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        int k = -10;
        System.out.println(subArrK(arr,k));
    }
}
