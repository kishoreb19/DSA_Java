package greedyAlgorithms;

import java.util.Arrays;
import java.util.List;

public class FractionalKnapsack {

    class Item {
        double perUnitVal;
        int val;
        int wt;

        Item(double perUnitVal, int val, int wt) {
            this.perUnitVal = perUnitVal;
            this.val = val;
            this.wt = wt;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = wt.size();
        Item[] items = new Item[n];

        // Calculate per-unit value and store data
        for (int i = 0; i < n; i++) {
            double perUnitVal = (double) val.get(i) / wt.get(i);
            items[i] = new Item(perUnitVal, val.get(i), wt.get(i));
        }

        // Sort items in descending order of per-unit value
        Arrays.sort(items,(a, b) -> Double.compare(b.perUnitVal,a.perUnitVal));

        double profit = 0.0;
        for (int i = 0; i < n; i++) {
            int currWt = items[i].wt;
            int currVal = items[i].val;
            double currPerUnitVal = items[i].perUnitVal;

            if (currWt <= capacity) {
                profit += currVal;
                capacity -= currWt;
            } else {
                profit += currPerUnitVal * capacity;
                break;
            }
        }
        return profit;
        //Time  Complexity - O(nlogn)
        //Space Complexity - O(n)
    }
    //https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
}
