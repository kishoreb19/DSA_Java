package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStore {

    static ArrayList<Integer> candyStore(int candies[], int N, int k){
        // code here
        int n = candies.length;
        Arrays.sort(candies);
        int min = 0;
        int buy = 0;
        int free = n-1;

        while(buy<=free){
            min += candies[buy];
            free = free - k;
            buy++;
        }

        int max = 0;
        buy = n-1;
        free = 0;

        while(buy>=free){
            max += candies[buy];
            free = free + k;
            buy--;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min); ans.add(max);
        return ans;
        //Time  Complexity - O(nlogn)
        //Space Complexity - O(1)
    }
    //https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
}
