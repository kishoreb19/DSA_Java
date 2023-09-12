package random_questions;

import java.util.ArrayList;
import java.util.Collections;

public class NumberAndDigits {
    public static int sumOfDigits(int n){
        int x =0;
        while(n>0){
            int r = n%10;
            x = x+r;
            n=n/10;
        }
        return x;
    }
    public static ArrayList<Integer> numbersAndDigits(int n) {

        // Create an empty array
        ArrayList<Integer> numList = new ArrayList<Integer>();

        for (int num = 1; num < 1001; ++num) {

            // Set the left and right values
            int leftVal = n - num;
            int rightVal = n + num;

            // Check if leftVal and sum of digits of leftVal is equal to N
            if (leftVal >= 0 && leftVal + sumOfDigits(leftVal) == n) {
                numList.add(leftVal);
            }

            // Check if rightVal and sum of digits of rightVal is equal to N
            if (rightVal + sumOfDigits(rightVal) == n && rightVal != leftVal) {
                numList.add(rightVal);
            }
        }

        // Return the array of numbers
        Collections.sort(numList);
        return numList;
        /*Time Complexity
O(1).
We are iteration from 1 to 1000 to check the numbers in the range from N -1000 to N + 1000. Hence, the overall time complexity is O(1).

Space Complexity
O(1).
We store an array of integers, but the array will contain very few integers in most cases. Hence, the overall space complexity is O(1).*/
    }
    public static void main(String[] args) {
        System.out.println(numbersAndDigits(5512));
        System.out.println("https://www.codingninjas.com/studio/problems/number-and-digits_975269?leftPanelTab=0");
    }
//    public static ArrayList<Integer> numbersAndDigits(int k) {
//
//        // Write your code here
//        ArrayList<Integer> obj = new ArrayList<>();
//        int low=0; int high = k;
//        while(low<=high){
//            int mid = low-(low-high)/2;
//            if(sumOfDigits(mid)+mid==k){
//                obj.add(mid);
//
//
//            }
//            if(sumOfDigits(mid)+mid<k){
//                low = mid+1;
//            }else{
//                high = mid-1;
//            }
//        }
//        return obj;
//    }


//public static ArrayList<Integer> numbersAndDigits(int k) {
//
//    // Write your code here
//    ArrayList<Integer> obj = new ArrayList<>();
//    for(int i =1;i<=k;i++){
//        if(sumOfDigits(i)+i==k){
//            obj.add(i);
//        }
//    }
//    return obj;
//}


}
