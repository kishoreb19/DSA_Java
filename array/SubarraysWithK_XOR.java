package array;

import java.util.HashMap;

public class SubarraysWithK_XOR {

    public long subarrayXor(int arr[], int K) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int xor = 0;
        long count = 0;

        //Formula: frontXOR = IntermediateXOR ^ K
        for(int i : arr){
            xor = xor ^ i;

            if(map.containsKey(xor^K)){
                count += map.get(xor^K);
            }
            map.put(xor,map.getOrDefault(xor,0) + 1);
        }
        return count;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    //https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
    //https://www.youtube.com/watch?v=eZr-6p0B7ME&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=22

    //Intuition
    /*
    4,2,2,6,4
    XR(intermediateXOR) = 4^2^2^6
    x (frontXOR) = 4
    K = 2^2^6

    then, x^K = XR
         (x^K)^K = XR^K
         x = XR^K
    which is -> Formula: frontXOR = IntermediateXOR ^ K

    which means if x exits in map, so a sub-array with K XOR exits
    Logic similar to sub-array with sum equal to K
    */
}
